package br.ufc.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufc.backend.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
