package com.codegym.musicappvalidate.service;

import com.codegym.musicappvalidate.model.Song;

import java.util.List;
import java.util.Optional;

public interface ISongService {
    Song save(Song song);
    Optional<Song> findById(Long id);
    List<Song> findAll();
}
