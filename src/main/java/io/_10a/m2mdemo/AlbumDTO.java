package io._10a.m2mdemo;

import java.util.List;

public record AlbumDTO(Long id, String title, List<SongDTO> songs) {}
