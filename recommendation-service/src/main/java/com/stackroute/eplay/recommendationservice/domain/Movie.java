package com.stackroute.eplay.recommendationservice.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonFormat;

@NodeEntity
public class Movie {
	@Id
	private int id;
	private String name;
	private String language;
	private String poster;
	
	private int rating;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate releaseDate;
	
	@Relationship(type="RELEASED_IN",direction=Relationship.OUTGOING)
	private List<City> cities ;
	
	@Relationship(type="IS_OF_GENRE",direction=Relationship.OUTGOING)
	private Genre genre;
	
	//@JsonIgnoreProperties("movie")
	@Relationship(type="VIEWED",direction=Relationship.INCOMING)
	private List<User> user;
		
	public Movie() {
		
	}
	public Movie(int id, String name, String language, String poster,int rating, Genre genre, LocalDate releaseDate) {
		this.id = id;
		this.name = name;
		this.language = language;
		this.poster = poster;
		this.rating = rating;
		this.genre = genre;
		this.releaseDate = releaseDate;
	}
	public void releasedIn(City city) {
		cities.add(city);
	}
	/*public Movie(int movieId, String title, String language, int rating) {
		this.id = movieId;
		this.name = title;
		this.language = language;
		this.rating = rating;
	}	*/
	
	
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public List<City> getCities() {
		return cities;
	}
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	
}
