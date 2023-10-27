package it.sidesoft.corso01.restulapp.controller;
import io.swagger.v3.oas.annotations.Operation;
import it.sidesoft.corso01.restulapp.dto.PersonaDto;
import it.sidesoft.corso01.restulapp.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @Operation(description = "restituire tutte le persone")
    @GetMapping("/persone")
    public List<PersonaDto> recuperoTutti(){
        return personaService.findAll();
    }

    @PostMapping("/persone")
    PersonaDto nuovaPersona(@RequestBody PersonaDto persona){
        return personaService.save(persona);
    }
    @GetMapping("/persone/{id}")
    PersonaDto recuperoPersona(@PathVariable Long id) {
        return personaService.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Impossibile trovare la persona con id:%s",id)));

    }
    @GetMapping("/persone/nome/{nome}")
    public List<PersonaDto> recuperaPersonaDaNome(@PathVariable String nome) {
        return personaService.findByNome(nome);
    }
    @GetMapping("/persone/cognome/{cognome}")
    public List<PersonaDto>  recuperaPersonaDacognome(@PathVariable String cognome) {
        return personaService.findByCognomeContainingIgnoreCase(cognome);
    }
}
