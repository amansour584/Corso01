package it.sidesoft.corso01.restulapp.services;


import it.sidesoft.corso01.restulapp.dto.ProgettoDto;
import it.sidesoft.corso01.restulapp.mapper.ProgettoDtoMapper;
import it.sidesoft.corso01.restulapp.model.Progetto;
import it.sidesoft.corso01.restulapp.repository.ProgettoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProgettoService  {
    @Autowired
    private ProgettoRepository progettoRepository;

    @Autowired
    private ProgettoDtoMapper progettoDtoMapper;

    public List<ProgettoDto> findAll(){
        log.info("Recupero tutti i progetti");
        List< Progetto > progettoList = progettoRepository.findAll();
        List<ProgettoDto> progettoDtoList = progettoDtoMapper.toDto(progettoList) ;
        return progettoDtoList;

    }
    public ProgettoDto save(ProgettoDto dto){
        log.info(String.format("Salvo progetto %s",dto.toString()));
        Progetto entity = progettoDtoMapper.toEntity(dto);
        entity = progettoRepository.save(entity);
        return  progettoDtoMapper.toDto(entity);
    }

    public Optional<ProgettoDto> findById(long id){
        log.info(String.format("Recupero progetto con ID: %s",id));
        Optional<Progetto> progetto = progettoRepository.findById(id);
        if (progetto.isPresent()){
            ProgettoDto dto1 = progettoDtoMapper.toDto(progetto.get());
            return Optional.of(dto1);
        }
        return Optional.empty();
    }
    public  List<ProgettoDto> ricercaProgetti(String titolo, Integer offset, Integer limit) {
        log.info("ricerco i progetti");
        List<Progetto> progettoList = progettoRepository.ricercaProgetti(titolo,offset,limit);
        return progettoDtoMapper.toDto(progettoList);
    }
}
