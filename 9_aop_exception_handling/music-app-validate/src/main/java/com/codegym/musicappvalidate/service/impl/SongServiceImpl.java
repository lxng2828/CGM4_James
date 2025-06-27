package com.codegym.musicappvalidate.service.impl;

import com.codegym.musicappvalidate.model.Song;
import com.codegym.musicappvalidate.repository.SongRepository;
import com.codegym.musicappvalidate.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements ISongService {

    @Autowired
    private SongRepository songRepository;

    @Override
    public Song save(Song song) {
        return songRepository.save(song);
    }

    @Override
    public Optional<Song> findById(Long id) {
        return songRepository.findById(id);
    }

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }
}
