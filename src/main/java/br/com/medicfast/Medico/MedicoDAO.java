package br.com.medicfast.Medico;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;

@Repository
@Transactional
public class MedicoDAO implements MedicoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void salvar(Medico medico) {
        entityManager.persist(medico);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Collection<Medico> buscarTodos() {
        return entityManager.createQuery("from Medico m").getResultList();
    }

    @Override
    public void remover(Integer id) {
        this.entityManager.remove(entityManager.getReference(Medico.class, id));
    }

    @Override
    public Medico buscarPor(Integer id) {
        return entityManager.find(Medico.class, id);
    }
}
