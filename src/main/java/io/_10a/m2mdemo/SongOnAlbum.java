package io._10a.m2mdemo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "SONGS_ON_ALBUMS")
public class SongOnAlbum implements Serializable {

	@EmbeddedId
	private SongOnAlbumId id;

	@Column(name = "POSITION")
	private Integer position;

	@ManyToOne
	@JoinColumn(name = "SONG_ID", referencedColumnName = "SONG_ID", insertable = false, updatable = false)
	protected Song song;

	public SongOnAlbumId getId() {
		return id;
	}

	public void setId(SongOnAlbumId id) {
		this.id = id;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Song getSong() {
		return song;
	}
}
