package com.chase.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.chase.main.models.Tv;
import com.chase.main.repos.TvRepo;

@Service
public class TvService {
	private final TvRepo tvRepo;
	
	public TvService(TvRepo tvRepo) {
		this.tvRepo = tvRepo;
	}
	
	public List<Tv> allShows(){
		return tvRepo.findAll();
	}
	
	public Tv createShow(Tv tv) {
		return tvRepo.save(tv);
	}
	
	public Tv findShow(Long id) {
		Optional<Tv> lang = tvRepo.findById(id);
		if(lang.isPresent()) {
			return lang.get();
		}else {
			return null;
		}
	}
	
	public void destroyLanguage(Long id) {
		Optional<Tv> lang = tvRepo.findById(id);
		if(lang.isPresent()) {
			tvRepo.deleteById(id);
		}
	}


	public Tv editShow(Tv tv) {
		return tvRepo.save(tv);
	}
	
	public Tv findById(Long id) {
		Optional<Tv> t = tvRepo.findById(id); 
		
		if(t.isPresent()) {
			return t.get(); 
		} else {
			return null; 
		}
	}

	public Tv saveShow(Tv tv) {
		return tvRepo.save(tv); 
	}
}