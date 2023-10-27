package it.sidesoft.corso01.restulapp.controller;

import it.sidesoft.corso01.restulapp.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CachingController {

    @Autowired
    private PersonaService personaService;


    @GetMapping("clearAllCaches")
    public void  clearAllCaches(){

        personaService.cleanCache();

    }
}
