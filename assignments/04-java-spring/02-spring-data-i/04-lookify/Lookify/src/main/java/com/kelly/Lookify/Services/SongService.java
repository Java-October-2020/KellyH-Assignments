package com.kelly.Lookify.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kelly.Lookify.Models.Song;
import com.kelly.Lookify.Repositories.SongRepo;

@Service
public class SongService{
	@Autowired
	private SongRepo sRepo;
	
	
	//Show All songs
	public List<Song> findAll(){
		return sRepo.findAll();
	}
	//Search by artits
	public List<Song> findByArtistContaining(String search){
		return sRepo.findByArtistContaining(search);
	}
	//Create
	public Song addSong(Song song) {
		return sRepo.save(song);
	}
	//Read
	public Song showSong(Long id) {
		Optional<Song> s = sRepo.findById(id);
		if (s.isPresent()) {
			return s.get();
		}
		else {
			return null;
		}
	}
	//Update
	public Song updateSong(Long id, String title, String artist, int rating) {
    	if (sRepo.findById(id) != null) { // dummy statement for the time being
    		Optional<Song> editSong = sRepo.findById(id);
    		Song s = editSong.get();
    		s.setTitle(title);
    		s.setArtist(artist);
    		s.setRating(rating);
    		sRepo.save(s);
    		return s;
    	}
    	else {
    		return null;
    	}
    	
	}
	//Delete
	public void deleteSong(Long id) {
		sRepo.deleteById(id);
	}
	
	//topTen
	public List<Song> findAllByOrderByRatingDesc(){
		return sRepo.findAllByOrderByRatingDesc();
	}
	
}