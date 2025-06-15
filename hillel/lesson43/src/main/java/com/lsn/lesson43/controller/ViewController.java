package com.lsn.lesson43.controller;

import com.lsn.lesson43.service.Limbo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ViewController {
    private final Limbo lim;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/users")
    public String users(Model mod) {
        mod.addAttribute("users", lim.getUsers());
        return "users";
    }

    @GetMapping("/")
    public String back() {
        return "redirect:/users";
    }

}
