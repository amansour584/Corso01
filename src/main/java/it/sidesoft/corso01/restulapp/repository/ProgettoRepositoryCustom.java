package it.sidesoft.corso01.restulapp.repository;

import it.sidesoft.corso01.restulapp.model.Progetto;

import java.util.List;

public interface ProgettoRepositoryCustom {
    List<Progetto> ricercaProgetti(String titolo, Integer offset, Integer limit);
}
