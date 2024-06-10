package com.infosupport.repos;

import com.infosupport.domain.JPAEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;

import java.util.Collection;

public abstract class Repo<E extends JPAEntity> {

    @PersistenceContext(name = "MySQL") // Container managed persistence context
    protected EntityManager em;

    public Collection<E> getAll() {
        return em.createNamedQuery(typeSimple() + ".findAll", E()).getResultList();
    }

    public E get(Integer id) { return em.find(E(), id); }

    public Collection<E> getByQ(String q) {
        TypedQuery<E> namedQuery = em.createNamedQuery(typeSimple() + ".search", E());
        namedQuery.setParameter("q", "%" + q + "%");
        return namedQuery.getResultList();
    }

    @Transactional
    public E add(E c) {
        em.persist(c);
        return c;
    }

    @Transactional
    public boolean remove(String id) {
        E e = em.find(E(), id);
        if (e == null) return false;

        em.remove(e);
        return true;
    }

    @Transactional
    public E update(Integer id, E e) {
        E found = em.find(E(), id);
        if (found == null) throw new BadRequestException("Entity with id " + id + " not found.");

        e.setId(id);
        return em.merge(e);
    }

    private String typeSimple() { return E().getSimpleName(); }

    public abstract Class<E> E();
}
