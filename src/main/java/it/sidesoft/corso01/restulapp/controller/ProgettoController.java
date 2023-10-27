package it.sidesoft.corso01.restulapp.controller;

import it.sidesoft.corso01.restulapp.dto.ProgettoDto;
import it.sidesoft.corso01.restulapp.services.ProgettoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class ProgettoController {

    @Autowired
    private ProgettoService progettoService;

    @GetMapping("/progetto")
    public List<ProgettoDto> recuperoTutti(){return progettoService.findAll();
    }
    @PostMapping("/progetto")
    ProgettoDto nuovoProgetto(@RequestBody ProgettoDto progetto){return  progettoService.save(progetto);
    }
    @GetMapping("/progetto/{id}")
    ProgettoDto recuperoProgetto(@PathVariable Long id) {
        return progettoService.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Impossibile trovare il progetto con id:%s",id)));
    }
    @GetMapping("/ricercaProgetti")
    List<ProgettoDto> ricercaProgetti(@RequestParam(value = "titolo")String titolo,
                                                            @RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                                            @RequestParam(value = "limit", defaultValue = "10") Integer limit){
        return  progettoService.ricercaProgetti(titolo,offset,limit);
    }
}
