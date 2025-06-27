package com.codegym.musicappvalidate.validate;

import com.codegym.musicappvalidate.model.Song;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SongValidator implements Validator {

    // Xác định class nào được validate
    @Override
    public boolean supports(Class<?> clazz) {
        return Song.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Song song = (Song) target;

        // Validate tên bài hát (trùng annotation, có thể bỏ qua nếu dùng annotation)
        if (song.getName() == null || song.getName().trim().isEmpty()) {
            errors.rejectValue("name", "name.empty", "Tên bài hát không được để trống");
        } else {
            if (song.getName().length() > 800) {
                errors.rejectValue("name", "name.length", "Tên bài hát không được vượt quá 800 ký tự");
            }
            // Kiểm tra ký tự đặc biệt cho name
            if (song.getName().matches(".*[@;,.=\\-+].*")) {
                errors.rejectValue("name", "name.specialChar", "Tên bài hát không được chứa ký tự đặc biệt như @ ; , . = - +");
            }
        }

        // Validate nghệ sĩ thể hiện
        if (song.getArtist() == null || song.getArtist().trim().isEmpty()) {
            errors.rejectValue("artist", "artist.empty", "Nghệ sĩ thể hiện không được để trống");
        } else {
            if (song.getArtist().length() > 300) {
                errors.rejectValue("artist", "artist.length", "Nghệ sĩ thể hiện không được vượt quá 300 ký tự");
            }
            if (song.getArtist().matches(".*[@;,.=\\-+].*")) {
                errors.rejectValue("artist", "artist.specialChar", "Nghệ sĩ thể hiện không được chứa ký tự đặc biệt như @ ; , . = - +");
            }
        }

        // Validate thể loại nhạc
        if (song.getGenre() == null || song.getGenre().trim().isEmpty()) {
            errors.rejectValue("genre", "genre.empty", "Thể loại nhạc không được để trống");
        } else {
            if (song.getGenre().length() > 1000) {
                errors.rejectValue("genre", "genre.length", "Thể loại nhạc không được vượt quá 1000 ký tự");
            }
            // Kiểm tra ký tự không hợp lệ ngoài dấu phẩy
            // Cho phép chữ, số, dấu phẩy và khoảng trắng
            if (!song.getGenre().matches("^[a-zA-Z0-9,\\s]*$")) {
                errors.rejectValue("genre", "genre.specialChar", "Thể loại nhạc chỉ được chứa chữ, số, khoảng trắng và dấu phẩy");
            }
        }
    }
}

