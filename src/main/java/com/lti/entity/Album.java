package com.lti.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Album")
public class Album {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private LocalDate releaseDate;
	private String copyright;
	
	@OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
	private List<Song> songs;

	public Album() {
		super();
	}

	public Album(int id, String name, LocalDate releaseDate, String copyright, List<Song> songs) {
		super();
		this.id = id;
		this.name = name;
		this.releaseDate = releaseDate;
		this.copyright = copyright;
		this.songs = songs;
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

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
		
}
