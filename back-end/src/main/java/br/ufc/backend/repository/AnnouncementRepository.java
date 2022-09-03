package br.ufc.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.backend.model.Announcement;
import br.ufc.backend.model.Usuario;

public interface AnnouncementRepository extends JpaRepository <Announcement, Integer > {
	Announcement findByCity(String city);
	List<Announcement> findAllByCity(String city);
	
}
