package com.kelly.Lookify.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kelly.Lookify.Models.Song;
import com.kelly.Lookify.Services.SongService;

@Controller
@RequestMapping("/")
public class HomeController{
	@Autowired
	private SongService sService;
	
	@RequestMapping("")
	public String home() {
		return "intro.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String index(Model model) {
		List<Song> allSongs = sService.findAll();
		model.addAttribute("songs", allSongs);
		System.out.println();
		return "index.jsp";
	}
	@RequestMapping("/search")
	public String search(@RequestParam(value="artist") String artist, Model model) {
		
		List<Song> song = sService.findByArtistContaining(artist);
		model.addAttribute("artist", artist);
		model.addAttribute("songsByArtist", song);
		//System.out.println(songs.toString());
		return "search.jsp";
	}
	@RequestMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song) {
		return "new.jsp";
	}
	@PostMapping("/songs/new")
	public String addSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if (result.hasErrors()) {
			return "new.jsp";
		}
		else {
			sService.addSong(song);
			return "redirect:/dashboard";
		}
	}
	@RequestMapping("/songs/{id}")
	public String showSong(@PathVariable("id") Long id, Model model) {
		Song song = sService.showSong(id);
		model.addAttribute("song", song);
		return "show.jsp";
	}
	@RequestMapping("/search/top10")
	public String topTen(Model model) {
		List<Song> top10 = sService.findAllByOrderByRatingDesc();
		model.addAttribute("topTen", top10);
		return "topTen.jsp";
	}

	@RequestMapping(value="/delete/{id}")
	public String deleteSong(@PathVariable("id") Long id) {
		sService.deleteSong(id);
		return "redirect:/dashboard";
	}
}