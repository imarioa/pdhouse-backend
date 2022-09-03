package br.ufc.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufc.backend.model.Announcement;
import br.ufc.backend.model.Usuario;
import br.ufc.backend.repository.AnnouncementRepository;
import br.ufc.backend.repository.UsuarioRepository;

@Service
public class AnnouncementService {
	@Autowired
	AnnouncementRepository announcementRepository;
    
    @Autowired
    UsuarioRepository usuarioRepository;
 
    public void update(int id, Announcement entity) {
    	Announcement announcement = find(id);       
    	announcement.setTitle(entity.getTitle());
    	announcement.setOwner(entity.getOwner());
    	announcement.setM_square_ground(entity.getM_square_ground());
    	announcement.setCity(entity.getCity());
    	announcement.setState(entity.getState());
    	announcement.setDistrict(entity.getDistrict());
    	announcement.setStreet(entity.getStreet());
    	announcement.setNumber_house(entity.getNumber_house());
    	announcement.setType(entity.getType());
    	announcement.setQt_bedrooms(entity.getQt_bedrooms());
    	announcement.setQt_bathrooms(entity.getQt_bathrooms());
    	announcement.setQt_garage_spaces(entity.getQt_garage_spaces());
    	announcement.setPrice(entity.getPrice());
    	announcement.setStatus(entity.getStatus());
        
    	announcementRepository.save(announcement);              
    }
    
    public void save(int usuario_id, Announcement entity) {
        Usuario usuario = usuarioRepository.findById(usuario_id).get();
        entity.setUsuario(usuario);
        announcementRepository.save(entity);                
    }
 
    public void delete(int id) {
    	Announcement announcement = find(id);
    	announcementRepository.delete(announcement);
    }
    public Announcement getAnnouncement(int id) {
    	 if (id < 1) {
             return null;
         }
  
         Optional<Announcement> announcement = announcementRepository.findById(id);
  
         if (announcement.isPresent()) {
             return announcement.get();
         }
  
         return null;
    }
    @Transactional 
    public Announcement find(int id) {
        if (id < 1) {
            return null;
        }
 
        Optional<Announcement> announcement = announcementRepository.findById(id);
 
        if (announcement.isPresent()) {
            return announcement.get();
        }
 
        return null;
    }
    public Announcement findByCity(String city) {
    	return announcementRepository.findByCity(city);
    }
    
    @Transactional 
    public List<Announcement> findAll() {
        return announcementRepository.findAll();
    }
    public List<Announcement> findAllbyCity(String city){
    	return announcementRepository.findAllByCity(city);
    }
    
    public List<Announcement> findFilters(double price, String city, String district, String state){
		List<Announcement> list = announcementRepository.findAll();
		List<Announcement> List = new ArrayList<Announcement>();
		
		
		if(list == null) {
			return null;
		}
		
		if(price != 0 && city.length()==0) {
			for (Announcement announcement : list) {
				if(announcement.getPrice()<=price) {
					List.add(announcement);
					
				}
			}
			
			return List;
		}		
		
		
		if(price != 0 && city.length()!=0) {
			for (Announcement announcement : list) {
				if(announcement.getCity().equals(city))
				List.add(announcement);
			}
			
			return List;
		}
		
		if(district.length()==0) {
			for (Announcement announcement : list) {
				if((announcement.getPrice()<=price) && announcement.getCity().equals(city))
				List.add(announcement);
			}
			
			return List;
		}
		
		if(state.length()==0) {
			for (Announcement announcement : list) {
				if((announcement.getPrice()<=price) && announcement.getCity().equals(city))
				List.add(announcement);
			}
			
			return List;
		}
		
	
		for (Announcement announcement : list) {
			if((announcement.getState().equals(state) && announcement.getCity().equals(city) && announcement.getDistrict().equals(district)
					&& announcement.getPrice()<=price))
			List.add(announcement);
		}
		
		return List;
	}
    
    
 
}
