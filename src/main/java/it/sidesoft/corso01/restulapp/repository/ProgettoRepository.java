package it.sidesoft.corso01.restulapp.repository;


import it.sidesoft.corso01.restulapp.model.Progetto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ProgettoRepository extends JpaRepository<Progetto, Long> , ProgettoRepositoryCustom{

}
