package com.kelly.Languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kelly.Languages.models.Lang;
import com.kelly.Languages.repositories.LangRepo;

@Service
public class LangService{
	
	//dependency injection
	private final LangRepo langRepo;
	    
		public LangService(LangRepo langRepo) {
			this.langRepo = langRepo;
	    }
	
	public List<Lang> allLangs(){
		return langRepo.findAll();
	}
	
	public Lang findLang(Long id) {
		Optional<Lang> l = langRepo.findById(id);
		if (l.isPresent()) {
			Lang lang = l.get();
			return lang;
		}
		else {
			return null;
		}
	}
	
	public Lang createLang(Lang l) {
		return langRepo.save(l);
	}
	
	public void updateLang(Long id, String name, String creator, float version) {
		Optional<Lang> l = langRepo.findById(id);
		Lang lang = l.get();
		lang.setName(name);
		lang.setCreator(creator);
		lang.setVersion(version);
		langRepo.save(lang);
	}
	public Lang update(Lang lang) {
		return langRepo.save(lang);
	}
	
	public void deleteLang(long id) {
		langRepo.deleteById(id);
	}
}