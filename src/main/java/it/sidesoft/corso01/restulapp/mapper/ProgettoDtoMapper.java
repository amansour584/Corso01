package it.sidesoft.corso01.restulapp.mapper;

import it.sidesoft.corso01.restulapp.dto.PersonaDto;
import it.sidesoft.corso01.restulapp.dto.ProgettoDto;
import it.sidesoft.corso01.restulapp.model.Persona;
import it.sidesoft.corso01.restulapp.model.Progetto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProgettoDtoMapper {
    ProgettoDto toDto(Progetto entity);
    List<ProgettoDto> toDto(List<Progetto> entity);
    @Mapping(target = "id", ignore = true)
    Progetto toEntity(ProgettoDto dto);
    @Mapping(target = "progetto", ignore = true)
    PersonaDto  toDto(Persona entity);
}
