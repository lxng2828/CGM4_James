package com.codegym.validating_song_info.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "song")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "khong duoc chua ky tu dac biet")
    @NotBlank(message = "song name cannot be blank")
    @Size(max = 800, message = "song name cannot exceed 800 characters")
    private String songName;

    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "khong duoc chua ky tu dac biet")
    @NotBlank(message = "artist name cannot be blank")
    @Size(max = 300, message = "song name cannot exceed 300 characters")
    private String artistName;

    @Pattern(regexp = "^[a-zA-Z0-9 ,]*$", message = "khong duoc chua ky tu dac biet")
    @NotBlank(message = "song name cannot be blank")
    @Size(max = 1000, message = "song name cannot exceed 1000 characters")
    private String category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "bai hat " + songName + " cua ten nghe si= " + artistName + " thuoc the loai= " + category
                + "]";
    }

}
