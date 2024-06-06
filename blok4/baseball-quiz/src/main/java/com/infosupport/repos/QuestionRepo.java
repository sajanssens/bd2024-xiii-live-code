package com.infosupport.repos;

import com.infosupport.domain.Question;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;

import java.util.List;
import java.util.Optional;

@ApplicationScoped // since bean-discovery-mode="annotated"
public class QuestionRepo {

    @PersistenceContext(name = "MySQL")
    private EntityManager em;

    @Transactional
    public Question create(Question q) {
        return em.merge(q);
    }

    public Optional<Question> read(int id) {
        return Optional.of(
                em.createQuery("select q from Question q where q.id = :id", Question.class)
                        .setParameter("id", id)
                        .getSingleResult());
    }

    public List<Question> readAll() {
        return em.createQuery("select q from Question q", Question.class)
                .getResultList();
    }

    @Transactional
    public Question update(Question q) {
        return em.merge(q);
    }

    @Transactional
    public void delete(int id) {
        em.remove(read(id).orElseThrow(BadRequestException::new));
    }
}
