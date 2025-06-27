package com.codegym.validating_song_info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codegym.validating_song_info.model.Song;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

}
