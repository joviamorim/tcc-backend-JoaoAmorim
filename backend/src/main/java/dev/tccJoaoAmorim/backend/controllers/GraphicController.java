package dev.tccJoaoAmorim.backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grafic")
public class GraphicController {

    @GetMapping("/teste")
    public String helloWorld() {
        return "Hello, World!";
    }

    @GetMapping("/testeErro")
    public String helloWorldErro() {
        return "Hello, World! Errado.";
    }

}
