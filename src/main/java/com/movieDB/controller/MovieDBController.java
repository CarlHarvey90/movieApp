package com.movieDB.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.movieDB.entity.movieEntity;
import com.movieDB.model.Movie;
import com.movieDB.repository.movieRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
//@RequestMapping({ "movies" })
public class MovieDBController {
	
	@Autowired
    movieRepository movieRepository;
	
	@GetMapping(path = "/movies")
    @ResponseBody
    public String allMovies() {

        StringBuffer retBuf = new StringBuffer();

        List<movieEntity> movies = (List<movieEntity>) movieRepository.findAll();
        
//        List<movieEntity> tempMovies = new ArrayList<movieEntity>();
//        movieEntity movieList = new movieEntity();
//        movieList.getMovieID();
//        movieList.getName();
//        movieList.getGenre();
//        movieList.getDesc();
//        
//        tempMovies.add(movieList);
//        return tempMovies.toString();
		
        if (movies != null) {
            for (movieEntity MovieEntity : movies) {
            	retBuf.append("movieID = ");
                retBuf.append(movieEntity.getMovieID());
                retBuf.append(" name = ");
                retBuf.append(movieEntity.getName());
                retBuf.append(" , genre = ");
                retBuf.append(movieEntity.getGenre());
                retBuf.append(" , desc = ");
                retBuf.append(movieEntity.getDesc());
                retBuf.append("\r\n");
            }
        }

        if (retBuf.length() == 0) {
            retBuf.append("No record find.");
        } else {
            retBuf.insert(0, "<pre>");
            retBuf.append("</pre>");
        }

        return retBuf.toString();
    }
	
//	private List<Movie> movies = generateList();
//
//	@RequestMapping(value = "/movies", method = RequestMethod.GET, produces = "application/json")
//	public List<Movie> firstPage() {
//		return movies;
//	}
//	
//	@PostMapping
//	public Movie create(@RequestBody Movie newMovie) {
//		movies.add(newMovie);
//		System.out.println(movies);
//		return newMovie;
//	}
//	
//	private static List<Movie> generateList() {
//		List<Movie> tempMovies = new ArrayList<Movie>();
//		Movie movie = new Movie();
//		movie.setMovieID("1");
//		movie.setName("Iron Man");
//		movie.setGenre("Action");
//		movie.setDesc("Iron Man is a 2008 American superhero film based on the Marvel Comics character of the same name, produced by Marvel Studios and distributed by Paramount Pictures");
//
//		Movie movie2 = new Movie();
//		movie2.setMovieID("2");
//		movie2.setName("Thor");
//		movie2.setGenre("Action");
//		movie2.setDesc("Thor is a 2011 American superhero film based on the Marvel Comics character of the same name, produced by Marvel Studios and distributed by Paramount Pictures");
//
//		tempMovies.add(movie);
//		tempMovies.add(movie2);
//		return tempMovies;
//	}

}
