package br.ufc.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.backend.model.Announcement;
import br.ufc.backend.service.AnnouncementService;

@RestController
@RequestMapping(path = "/api")
public class AnnouncementController {
	@Autowired
	AnnouncementService service;
	
	
	@GetMapping("/announcements")
    public ResponseEntity<List<Announcement>> findAll() {
        return new ResponseEntity<List<Announcement>>(service.findAll(), HttpStatus.OK);
    }
 
    @GetMapping("/announcements/{id}")
    public ResponseEntity<Announcement> find(@PathVariable("id") int id) {
        return new ResponseEntity<Announcement>(service.getAnnouncement(id), HttpStatus.OK);
    }
 
    @PostMapping("/usuarios/{id}/announcements")
    public void save(@PathVariable("id") int product_id, @RequestBody Announcement announcement) {
        service.save(product_id, announcement);
    }
 
    @PutMapping("/announcements/{id}")
    public void update(@PathVariable("id") int id, @RequestBody Announcement announcement) {
        service.update(id, announcement);
    }
    
    @GetMapping("/announcements/search")
	public ResponseEntity<List<Announcement>> findByCity(@RequestParam("city") String city) {
    	List <Announcement> product = service.findAllbyCity(city);
	
		if(product != null) {
			return new ResponseEntity<List<Announcement>>(product, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Announcement>>(product, HttpStatus.NOT_FOUND);
		}
	}
    
    @GetMapping("/searchFilter")
    public ResponseEntity<List<Announcement>> findFilters(@RequestParam("price") double price,  @RequestParam("city") String city, @RequestParam("district") String district, @RequestParam("state") String state){
    	List<Announcement> list = service.findFilters(price, city, district, state);
    	
    	if(list != null) {
    		return new ResponseEntity<List<Announcement>>(list, HttpStatus.OK);
    	} else {
    		return new ResponseEntity<List<Announcement>>(HttpStatus.NOT_FOUND);

    	}
    }
 
    @DeleteMapping("/announcements/{id}")
    public void delete(@PathVariable("id") int id) {
        service.delete(id);
    }
}
