package br.ufc.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.backend.model.Usuario;
import br.ufc.backend.service.UsuarioService;

@RestController
@RequestMapping(path = "/api/usuarios")
public class UsuarioController {
	@Autowired
    UsuarioService service;
 
	@GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        return new ResponseEntity<List<Usuario>>(service.findAll(), HttpStatus.OK);
    }
 
    @GetMapping(path = "{id}")
    public ResponseEntity<Usuario> find(@PathVariable("id") int id) {
        Usuario Usuario = service.find(id);
        
        if(Usuario != null) {
            return new ResponseEntity<Usuario>(Usuario, HttpStatus.OK);  
        } else {
            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
        }
    }
 
    @GetMapping(path = "/search")
    public ResponseEntity<Usuario> findByName(@RequestParam("name") String name) {
        Usuario product = service.findByName(name);
        
        if(product != null) {
            return new ResponseEntity<Usuario>(product, HttpStatus.OK);  
        } else {
            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping(path = "/procurar")
    public ResponseEntity<Usuario> findByEmail(@RequestParam("email") String email) {
        Usuario product = service.findByEmail(email);
        
        if(product != null) {
            return new ResponseEntity<Usuario>(product, HttpStatus.OK);  
        } else {
            return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping(path = "/register")
    public void save(@RequestBody Usuario user) {
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
        service.save(0, user);     	
    }

    @PutMapping(path = "{id}")
    public void update(@PathVariable("id") int id, @RequestBody Usuario user) {
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
        service.save(id, user);
    }
 
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") int id) {
        service.delete(id);
    }
}
