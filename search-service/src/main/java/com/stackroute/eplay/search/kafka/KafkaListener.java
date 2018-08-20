package com.stackroute.eplay.search.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;

import com.stackroute.eplay.search.domain.Movie;
import com.stackroute.eplay.search.domain.MovieEvent;
import com.stackroute.eplay.search.services.SearchService;
import com.stackroute.eplay.search.streams.MovieEventStream;
import com.stackroute.eplay.search.streams.MovieStream;

@EnableBinding({ MovieEventStream.class, MovieStream.class })
public class KafkaListener {

	private SearchService searchService;
	// private MovieEventStream movieEventStream;
	// private MovieStream movieStream;

	@Autowired
	public KafkaListener(SearchService searchService) {
		this.searchService = searchService;
		// this.movieEventStream = movieEventStream;
		// this.movieStream = movieStream;
	}

	// Listener for movie event object stream
	@StreamListener(MovieEventStream.INPUT)
	public void movieEventPost(@Payload MovieEvent movieEvent) {
		String city = movieEvent.getCity();
		int movieId = movieEvent.getMovieId();
		Movie movie = searchService.getMovieById(movieId);

		searchService.updateCityMovies(city, movie);
	}

	// Listener for movie object stream
	@StreamListener(MovieStream.INPUT)
	public void moviePost(@Payload Movie movie) {
		searchService.saveMovie(movie);

	}
}
