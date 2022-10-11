package io._10a.m2mdemo;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ALBUMS")
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ALBUM_ID")
	private Long id;

	@Column(name = "TITLE")
	private String title;

	@OneToMany
	@JoinColumn(name = "ALBUM_ID",referencedColumnName = "ALBUM_ID")
	private Set<SongOnAlbum> songs;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<SongOnAlbum> getSongs() {
		return songs;
	}

	public void setSongs(Set<SongOnAlbum> songs) {
		this.songs = songs;
	}
}
