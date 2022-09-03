package br.ufc.backend.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.ufc.backend.service.PdSignService;

@RestController
@RequestMapping(path = "/api/posts")
public class PdSignController {

	@Autowired
	PdSignService service;
	
	@PostMapping(path = "/create")
	public String createProcessAndFile(@RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + file.getName());
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				System.out.println("Uploaded !!");
			} catch (Exception e) {
				System.out.println("Failed");
			}
		} else {
			System.out.println("Empty");
		}

		service.getToken();
		String idProcess = service.createProcess();
		service.createFile();
		service.uploadFile(file);
		service.patchProcess();
		return idProcess;
	}
	
	@GetMapping(path = "/status/{process}")
	public String getStatus(@PathVariable("process") String process) {
		service.getToken();
		return service.checkReady(process);
	}
}