package com.example.thesis_is_coming.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {


    @GetMapping("/student")
    public String helloStudet() {
        return "student";
    }
}
