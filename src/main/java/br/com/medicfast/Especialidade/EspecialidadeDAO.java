package br.com.medicfast.Especialidade;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class EspecialidadeDAO implements EspecialidadeRepository{

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public void salvar(Especialidade especialidade) {
        entityManager.persist(especialidade);
    }
}
