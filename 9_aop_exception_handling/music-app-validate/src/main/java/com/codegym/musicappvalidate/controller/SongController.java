package com.codegym.musicappvalidate.controller;

import com.codegym.musicappvalidate.model.Song;
import com.codegym.musicappvalidate.service.impl.SongServiceImpl;
import com.codegym.musicappvalidate.validate.SongValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/songs")
public class SongController {

//    @Autowired
//    private SongValidator songValidator;

    @Autowired
    private SongServiceImpl songService;

//    @InitBinder("song")
//    protected void initBinder(WebDataBinder binder) {
//        binder.addValidators(songValidator);
//    }

    // Hiển thị form thêm bài hát
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("song", new Song());
        return "song_form";
    }

    // Xử lý thêm bài hát mới
    @PostMapping("/add")
    public String addSong(@Valid @ModelAttribute("song") Song song,
                          BindingResult result,
                          Model model) {
        if (result.hasErrors()) {
            return "song_form";
        }

        songService.save(song); // Lưu bài hát vào DB

        model.addAttribute("message", "Thêm bài hát thành công!");
        model.addAttribute("song", new Song()); // reset form sau khi thêm thành công
        return "redirect:/songs/list";
    }

    // Hiển thị form sửa bài hát
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<Song> existingSong = songService.findById(id);
        if (existingSong.isPresent()) {
            model.addAttribute("song", existingSong.get());
        } else {
            model.addAttribute("message", "Bài hát không tồn tại!");
            model.addAttribute("song", new Song());
        }
        return "song_form";
    }

    // Xử lý cập nhật bài hát
    @PostMapping("/edit/{id}")
    public String updateSong(@PathVariable("id") Long id,
                             @Valid @ModelAttribute("song") Song song,
                             BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            return "song_form";
        }

        song.setId(id);  // Đảm bảo id để update đúng bản ghi
        songService.save(song);

        model.addAttribute("message", "Cập nhật bài hát thành công!");
        return "redirect:/songs/list";
    }

    // Hiển thị danh sách bài hát
    @GetMapping({"", "/", "/list"})
    public String listSongs(Model model) {
        model.addAttribute("songs", songService.findAll());
        return "list";
    }
}
