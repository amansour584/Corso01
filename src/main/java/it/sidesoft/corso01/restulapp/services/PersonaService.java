package it.sidesoft.corso01.restulapp.services;

import it.sidesoft.corso01.restulapp.dto.PersonaDto;
import it.sidesoft.corso01.restulapp.mapper.PersonaDtoMapper;
import it.sidesoft.corso01.restulapp.model.Persona;
import it.sidesoft.corso01.restulapp.repository.PersonaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@CacheConfig(cacheNames = {"persone"})
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private PersonaDtoMapper personaDtoMapper;

    @Autowired
    private CacheManager cacheManager;

    @Cacheable
    public List<PersonaDto> findAll(){
        log.info("Recupero tutte le persone");
        List<Persona> personaList = personaRepository.findAll();
        List<PersonaDto> personaDtoList = personaDtoMapper.toDto(personaList) ;
        return personaDtoList;

    }
    @Cacheable(value = "persona", key = "#nome",sync = true)
    public List<PersonaDto> findByNome(String nome){
        List<Persona> personaList = personaRepository.findByNome(nome);
        List<PersonaDto> personaDtoList = personaDtoMapper.toDto(personaList);
        return personaDtoList;
    }
    public List<PersonaDto> findByCognomeContainingIgnoreCase(String cognome){
        List<Persona> personaList = personaRepository.findByCognomeContainingIgnoreCase(cognome);
        List<PersonaDto> personaDtoList = personaDtoMapper.toDto(personaList);
        return personaDtoList;
    }
    @Caching(evict = {
            @CacheEvict(cacheNames = "persone",allEntries = true),
            @CacheEvict(cacheNames = "persona", key = "#dto.nome")
    })
    public PersonaDto save(PersonaDto dto){
        log.info(String.format("Salvo persona: %s",dto.toString()));
        Persona entity = personaDtoMapper.toEntity(dto);
        entity = personaRepository.save(entity);
        return  personaDtoMapper.toDto(entity);
    }

    public Optional<PersonaDto> findById(long id){
        log.info(String.format("Recupero persona con ID: %s",id));
        Optional<Persona> persona = personaRepository.findById(id);
        if (persona.isPresent()){
            PersonaDto dto1 = personaDtoMapper.toDto(persona.get());
            return Optional.of(dto1);
        }
        return Optional.empty();
    }
    public void  cleanCache(){

        log.info("avvio pulizia di tutte le cache");
        Collection<String> cacheNames = cacheManager.getCacheNames();

        cacheNames.forEach((item) -> {

            log.info(String.format("elimino la cache:%",item));
            Objects.requireNonNull(cacheManager.getCache(item)).clear();

        });

    }
}
