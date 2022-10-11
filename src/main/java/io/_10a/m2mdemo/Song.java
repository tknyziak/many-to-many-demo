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
@Table(name = "SONGS")
public class Song {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SONG_ID")
	private Long id;

	@Column(name = "TITLE")
	private String title;

	@OneToMany(mappedBy = "song")
	private Set<SongOnAlbum> albums;

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

	public Set<SongOnAlbum> getAlbums() {
		return albums;
	}

	public void setAlbums(Set<SongOnAlbum> albums) {
		this.albums = albums;
	}
}
