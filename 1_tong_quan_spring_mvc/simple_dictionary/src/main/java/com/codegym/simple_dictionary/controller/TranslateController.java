package com.codegym.simple_dictionary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TranslateController {

    private static final Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("morning", "buổi sáng");
        dictionary.put("night", "ban đêm");
        dictionary.put("water", "nước");
        dictionary.put("fire", "lửa");
        dictionary.put("earth", "đất");
        dictionary.put("wind", "gió");
        dictionary.put("sky", "bầu trời");
        dictionary.put("computer", "máy tính");
        dictionary.put("keyboard", "bàn phím");
        dictionary.put("screen", "màn hình");
        dictionary.put("internet", "mạng internet");
        dictionary.put("language", "ngôn ngữ");
        dictionary.put("code", "mã");
        dictionary.put("program", "chương trình");
        dictionary.put("function", "hàm");
        dictionary.put("variable", "biến");
        dictionary.put("loop", "vòng lặp");
        dictionary.put("error", "lỗi");
        dictionary.put("success", "thành công");
        dictionary.put("failure", "thất bại");
    }

    @GetMapping("/")
    public String showForm(){
        return "trans_form";
    }

    @PostMapping("/trans")
    public String trans(@RequestParam("engword") String eng_word, Model m){
        m.addAttribute("engword",eng_word);
        String rs = dictionary.get(eng_word);
        if (rs == null) {
            rs = "Không tìm thấy từ cần dịch";
        }
        m.addAttribute("viword", rs);
        return "result";
    }
}
