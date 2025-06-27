package com.codegym.validating_song_info.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codegym.validating_song_info.model.Song;
import com.codegym.validating_song_info.repository.SongRepository;

@Service
public class SongService {
    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> getAllSong() {
        return songRepository.findAll();
    }

    public Song addNewSong(Song song) {
        Song songAdded = songRepository.save(song);
        return songAdded;
    }
}