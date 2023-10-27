package it.sidesoft.corso01.restulapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {

    private static  final  String template = "Hello,%s!";

    @GetMapping("/saluti")
    public String greeting(@RequestParam(value = "name", defaultValue = "world")String name){
        return  String.format(template,name);
    }
}
