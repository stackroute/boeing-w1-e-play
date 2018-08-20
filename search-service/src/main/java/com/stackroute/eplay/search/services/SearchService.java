package com.stackroute.eplay.search.services;

import java.util.List;

import com.stackroute.eplay.search.domain.City;
import com.stackroute.eplay.search.domain.Movie;
import com.stackroute.eplay.search.domain.Query;
import com.stackroute.eplay.search.exceptions.MovieNotFoundException;

public interface SearchService {

	public Movie saveMovie(Movie movie);

	public Iterable<Movie> getEventsByCity(String city);

	public Iterable<Query> getAllQueries();

	public City updateCityMovies(String cityName, Movie movie);

	public Movie getMovieById(int id);

	public List<Movie> getMovieAutoSuggestions(String searchstr);

	public Iterable<Movie> getMoviesByName(String name) throws MovieNotFoundException;

}