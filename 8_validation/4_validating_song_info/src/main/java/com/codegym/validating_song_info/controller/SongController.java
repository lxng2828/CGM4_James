package com.codegym.validating_song_info.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.codegym.validating_song_info.model.Song;
import com.codegym.validating_song_info.service.SongService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("/")
    public String getAllSong(Model model) {
        model.addAttribute("songList", songService.getAllSong());
        return "list";
    }

    @GetMapping("/addNewSong")
    public String showFormAddNewSong(Model model) {
        model.addAttribute("song", new Song());
        return "form";
    }

    @PostMapping("/addNewSong")
    public String postMethodName(@Valid @ModelAttribute Song song, Model model, BindingResult result) {
        if (result.hasErrors()) {
            return "form";
        }
        Song songAdded = songService.addNewSong(song);
        String songInfo = songAdded.toString();
        model.addAttribute("songInfo", songInfo);
        return "addSuccess";
    }

}
