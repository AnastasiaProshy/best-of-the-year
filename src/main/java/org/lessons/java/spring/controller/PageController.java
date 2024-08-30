package org.lessons.java.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.lessons.java.spring.model.Movie;
import org.lessons.java.spring.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class PageController 
{
	
	@GetMapping("/")			// just "/" instead of /homepage making the home page the root of my domain
	public String homepage( Model model )
	{
		model.addAttribute("name", "Nasty");
		return "homepage";
	}
		
	
	
	
	@GetMapping("/movies")	
	public String movieTitles( Model model )
	{		
		model.addAttribute("title", "Best movies list");			
		
		String bestMovies = " " ;
		
		for (Movie movies : getBestMoviesList())
		{
			bestMovies += movies.getTitle() + " -- ";
		}
		
		model.addAttribute("list", bestMovies);
		
		return "titles";
	}

	
	
	
	@GetMapping("/movies/{id}")
	public String movieDetails( Model model, @PathVariable("id") Integer movieId )
	{		
		model.addAttribute("title", "Single Movie Detail");			
		
		String movieTitle = null ;
		
		for (Movie movies : getBestMoviesList())
		{
			if(movieId.equals(movies.getId()))
			{
				movieTitle = movies.getTitle();
				break;
			}
		}
		
		model.addAttribute ("name", movieTitle);
		
		return "details";
	}
	
	
	
	
	@GetMapping("/songs")
	public String songTitles( Model model )
	{		
		model.addAttribute("title", "Best songs list");		
		
		String bestSongs = " " ;
		
		for (Song songs : getBestSongsList())
		{
			bestSongs += songs.getTitle() + " - ";
		}
		
		model.addAttribute("list", bestSongs);
		
		return "titles";
	}
	
	
	
	
	@GetMapping("/songs/{id}")
	public String songDetails ( Model model, @PathVariable("id") Integer songId )
	{		
		model.addAttribute("title", "Single Songs Detail");			
		
		String songTitle = null ;
		
		for (Song songs : getBestSongsList())
		{
			if(songId.equals(songs.getId()))
			{
				songTitle = songs.getTitle();
				break;
			}
		}
		
		model.addAttribute("name", songTitle);
		
		return "details";
	} 	
	
	
	
	
	private List<Movie> getBestMoviesList()
	{
		List<Movie> movies= new ArrayList<Movie>();				// Create a movie list
		movies.add(new Movie(1, "Smith"));								// Add movie to list
		movies.add(new Movie(2, "Via della Rose"));
		movies.add(new Movie(3, "UBL Notions"));				
		movies.add(new Movie(4, "This is us"));
		movies.add(new Movie(5, "WIll"));				
		movies.add(new Movie(6, "My lovely Oppa"));
		return movies;
	}
	
	
	
	
	private List<Song> getBestSongsList()
	{
		List<Song> songs = new ArrayList<Song>();			// Create a list of songs
		songs.add(new Song(1, "Pink"));								// Add song to list
		songs.add(new Song(2, "Love you"));
		songs.add(new Song(3, "Not bed"));
		songs.add(new Song(4, "Come to me"));
		songs.add(new Song(5, "Radio"));
		songs.add(new Song(6, "So good"));
		return songs;
	}	
	
}
	