package br.ufc.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufc.backend.model.Usuario;
import br.ufc.backend.repository.UsuarioRepository;

@Service	
public class UsuarioService {
	@Autowired
    UsuarioRepository UsuarioRepository;

 
    public void save(int id, Usuario entity) {
        if(id != 0) {
            entity.setId(id);
        }
        UsuarioRepository.save(entity);
    }
 
    public void delete(int id) {
        Usuario product = find(id);
        UsuarioRepository.delete(product);
    }
    public Usuario find(int id) {
        if(id < 1) {
            return null;
        }
        
        Optional<Usuario> product = UsuarioRepository.findById(id);
        
        if(product.isPresent()) {
            return product.get();   
        }
        
        return null;        
    }
    @Transactional 
    public List<Usuario> findAll() {
        return UsuarioRepository.findAll();
    }
    
    public Usuario findByName(String name) {
    	return UsuarioRepository.findFirstByName(name);
    }
    public Usuario findByEmail(String email) {
    	return UsuarioRepository.findByEmail(email);
    }
    
    public List<Usuario> findAllbyName(String name){
    	return UsuarioRepository.findAllByName(name);
    }
}
