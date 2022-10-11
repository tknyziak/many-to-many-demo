package io._10a.m2mdemo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SongOnAlbumId implements Serializable {

	@Column(name = "SONG_ID")
	private Long songId;

	@Column(name = "ALBUM_ID")
	private Long albumId;

	public Long getSongId() {
		return songId;
	}

	public void setSongId(Long songId) {
		this.songId = songId;
	}

	public Long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}
}
