package br.ufc.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.backend.model.Usuario;

public interface UsuarioRepository  extends JpaRepository <Usuario, Integer > {
	Usuario findFirstByName (String name);
	List<Usuario> findAllByName (String name);
	Usuario findByEmail(String email);
	
}
