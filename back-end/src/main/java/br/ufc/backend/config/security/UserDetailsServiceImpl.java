package br.ufc.backend.config.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.ufc.backend.model.Usuario;
import br.ufc.backend.repository.UsuarioRepository;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UsuarioRepository loginRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario login = loginRepository.findByEmail(email);
		return new User(login.getUsername(), login.getPassword(), true, true, true, true, login.getAuthorities());
	}

}

