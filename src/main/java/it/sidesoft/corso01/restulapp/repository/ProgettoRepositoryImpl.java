package it.sidesoft.corso01.restulapp.repository;

import it.sidesoft.corso01.restulapp.model.Progetto;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProgettoRepositoryImpl  implements  ProgettoRepositoryCustom{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Progetto> ricercaProgetti(String titolo, Integer offset, Integer limit){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Progetto> cq = cb.createQuery(Progetto.class);
        Root<Progetto> progetto = cq.from(Progetto.class);
        List<Predicate> predicates = new ArrayList<>();

        if (StringUtils.isNotEmpty(titolo)){
            predicates.add(cb.like(progetto.get("titolo"),("%"+ titolo + "%")));
        }
        cq.where((Predicate[]) predicates.toArray(new Predicate[predicates.size()]));
        cq.orderBy(cb.desc(progetto.get("titolo")));
        TypedQuery<Progetto> query = em.createQuery(cq);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.getResultList();
    }

}
