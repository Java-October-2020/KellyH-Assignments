package com.kelly.Lookify.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kelly.Lookify.Models.Song;


@Repository
public interface SongRepo extends CrudRepository<Song, Long>{
	List<Song> findAll();
	
	List<Song> findAllByOrderByRatingDesc(); // top 10
	
	List<Song> findByTitleContaining(String search); // search by title
	
	List<Song> findByArtistContaining(String search); //search by artist
		
	Long countByTitleContaining(String search); // this method deletes a book that starts with a specific title
    
	Long deleteByTitleStartingWith(String search); // this method returns the number of entities available
    

}