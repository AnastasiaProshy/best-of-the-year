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

	
	@GetMapping("/")		// just "/" instead of /homepage making the home page the root of my domain
	public String homepage( Model model )
	{
		model.addAttribute("name", "Nasty");
		return "homepage";
	}
		
	
	
	
	@GetMapping("/movies")
//	public String getBestMovies( Model model )
//	{		
//		List<Movie> bestMovies = getBestMoviesList();			// Get the list of top movies
//		model.addAttribute("bestMovies", bestMovies);			// the name corresponds to the html file		
//		return "movies";
//	}
		
	public String movieTitles( Model model )
	{		
		model.addAttribute("title", "Best movies list");			
		
		String bestMovies = " " ;
		
		for (Movie movie : getBestMoviesList())
		{
			bestMovies += movie.getTitle() + " - ";
		}
		
		model.addAttribute("list", bestMovies);
		
		return "movies";
	}
	
	
	
	
	@GetMapping("/movies/{id}")
	public String movieDetails( Model model, @PathVariable("id") Integer movieId )
	{		
		model.addAttribute("title", "Single Movie Detail");			
		
		String movieTitle = null ;
		
		for (Movie movie : getBestMoviesList())
		{
			if(movieId.equals(movie.getid()))
			{
				movieTitle = movie.getTitle();
				break;
			}
		}
		
		model.addAttribute("name", movieTitle);
		
		return "details";
	}
	
	
	@GetMapping("/songs")
//	public String getBestSongs( Model model )
//	{
//		List<Song> bestSongs = getBestSongsList();					// Retrieve the top songs list
//		model.addAttribute("bestSongs", bestSongs);				// the name corresponds to the html file
//		return "songs";
//	}
	
	
	@GetMapping("/songs")
	public String songTitles( Model model )
	{		
		model.addAttribute("title", "Best songs list");			
		
		String bestSongs = " " ;
		
		for (Song song : getBestSongsList())
		{
			bestSongs += song.getTitle() + " - ";
		}
		
		model.addAttribute("list", bestSongs);
		
		return "songs";
	}
	
	
	
	
	@GetMapping("/songs/{id}")
	public String songDetails ( Model model, @PathVariable("id") Integer songId )
	{		
		model.addAttribute("title", "Single Songs Detail");			
		
		String songTitle = null ;
		
		for (Song song : getBestSongsList())
		{
			if(songId.equals(song.getid()))
			{
				songTitle = song.getTitle();
				break;
			}
		}
		
		model.addAttribute("name", songTitle);
		
		return "details";
	} 	
	
	
	
	
	private List<Movie> getBestMoviesList()
	{
		List<Movie> bestMovies= new ArrayList<>();				// Create a movie list
		bestMovies.add(new Movie(123465, "Smith"));				// Add movie to list
		bestMovies.add(new Movie(123466, "Via della Rose"));
		bestMovies.add(new Movie(123467, "UBL Notions"));				// Add movie to list
		bestMovies.add(new Movie(123468, "This is us"));
		bestMovies.add(new Movie(123469, "WIll"));				// Add movie to list
		bestMovies.add(new Movie(123470, "My lovely Oppa"));
		return bestMovies;
	}
	
	
	
	private List<Song> getBestSongsList()
	{
		List<Song> bestSongs = new ArrayList<>();			// Create a list of songs
		bestSongs.add(new Song(12345, "Pink"));					// Add song to list
		bestSongs.add(new Song(12346, "Love you"));
		bestSongs.add(new Song(12347, "Not bed"));
		bestSongs.add(new Song(12348, "Come to me"));
		bestSongs.add(new Song(12349, "Radio"));
		bestSongs.add(new Song(12350, "So good"));
		return bestSongs;
	}	
	
}
	