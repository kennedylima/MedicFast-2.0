package br.com.medicfast.Medico;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class MedicoDAO implements MedicoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void salvar(Medico medico) {
        entityManager.persist(medico);
    }
}
