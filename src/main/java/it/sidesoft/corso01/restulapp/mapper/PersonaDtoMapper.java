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
public interface PersonaDtoMapper {
    PersonaDto toDto(Persona entity);
    List<PersonaDto> toDto(List<Persona> entity);
    @Mapping(target = "persone", ignore = true)
    ProgettoDto toDto(Progetto entity);
    @Mapping(target = "id", ignore = true)
    Persona toEntity(PersonaDto dto);
}
