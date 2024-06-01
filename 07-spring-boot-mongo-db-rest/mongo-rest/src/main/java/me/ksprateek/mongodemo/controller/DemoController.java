package me.ksprateek.mongodemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/check")
public class DemoController {
    @GetMapping("")
    public String check() {
        return "Hello World! I'm up and running";
    }
}
