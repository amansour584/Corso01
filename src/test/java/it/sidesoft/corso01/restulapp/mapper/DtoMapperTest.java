package it.sidesoft.corso01.restulapp.mapper;

import it.sidesoft.corso01.restulapp.dto.PersonaDto;
import it.sidesoft.corso01.restulapp.dto.ProgettoDto;
import it.sidesoft.corso01.restulapp.model.Persona;
import it.sidesoft.corso01.restulapp.model.Progetto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DtoMapperTest {

    @Autowired
    private PersonaDtoMapper personaDtoMapper;
    @DisplayName("test entità persona verso -Metodo toDto")
    @Test
    public Void toPersonaDto(){
        Persona entity = creaPersona();
        PersonaDto dto = personaDtoMapper.toDto(entity);
    }

    private void checkPersonaDto(Persona entity,PersonaDto dto){
        assertNotNull(entity);
        assertNotNull(dto);
        assertAll("checkPersonaDto",
                ()->assertEquals(entity.getId(),dto.getId()),
                ()->assertEquals(entity.getCognome(),dto.getCognome()),
                ()->assertEquals(entity.getNome(),dto.getNome()),
                ()->checkProgettoDto(entity.getProgetto(),dto.getProgetto());
    }

    private void checkProgettoDto(Progetto entity, ProgettoDto dto){
        assertNotNull(entity);
        assertNotNull(dto);
        assertAll("checkProgettoDto",
                ()->assertEquals(entity.getId(),dto.getId()),
                ()->assertEquals(entity.getDescrizione(),dto.getDescrizione()),
                ()->assertEquals(entity.getTitolo(),dto.getTitolo()),
                ()->assertNull(dto.getPersone()));
    }

}
