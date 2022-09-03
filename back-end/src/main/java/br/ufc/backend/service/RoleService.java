package br.ufc.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.backend.model.Role;
import br.ufc.backend.model.Usuario;
import br.ufc.backend.repository.RoleRepository;
import br.ufc.backend.repository.UsuarioRepository;

@Service
public class RoleService {

	@Autowired
	RoleRepository repository;
	
	@Autowired
	UsuarioRepository loginRepository;

	public void save(Role entity) {
		repository.save(entity);
	}
	
	public void addRole(int id, int userId) {
		Usuario login = loginRepository.findById(userId).get();
		Role role = repository.findById(id).get();			
		
		List<Role> roles = login.getRoles();
		
		if(roles != null) {
			roles.add(role);
		} else {
			roles = new ArrayList<Role>();
			roles.add(role);
		}
		
		login.setRoles(roles);
		loginRepository.save(login);
	}
	
	public List<Role> findAll() {
        return repository.findAll();
    }
}
