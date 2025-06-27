package com.codegym.musicappvalidate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "songs")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Tên bài hát
    @NotBlank(message = "Tên bài hát không được để trống")
    @Size(max = 800, message = "Tên bài hát không được vượt quá 800 ký tự")
    @Pattern(regexp = "^[^@;,.=\\-+]*$", message = "Tên bài hát không được chứa ký tự đặc biệt như @ ; , . = - +")
    private String name;

    // Nghệ sĩ thể hiện
    @NotBlank(message = "Nghệ sĩ thể hiện không được để trống")
    @Size(max = 300, message = "Nghệ sĩ thể hiện không được vượt quá 300 ký tự")
    @Pattern(regexp = "^[^@;,.=\\-+]*$", message = "Nghệ sĩ thể hiện không được chứa ký tự đặc biệt như @ ; , . = - +")
    private String artist;

    // Thể loại nhạc
    @NotBlank(message = "Thể loại nhạc không được để trống")
    @Size(max = 1000, message = "Thể loại nhạc không được vượt quá 1000 ký tự")
    @Pattern(regexp = "^[a-zA-Z0-9,\\s]*$", message = "Thể loại nhạc chỉ được chứa chữ, số, khoảng trắng và dấu phẩy")
    private String genre;
}
