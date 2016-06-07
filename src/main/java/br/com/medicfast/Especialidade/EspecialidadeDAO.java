package br.com.medicfast.Especialidade;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;

@Repository
@Transactional
public class EspecialidadeDAO implements EspecialidadeRepository{

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public void salvar(Especialidade especialidade) {
        entityManager.persist(especialidade);
    }

    @Override
    public Especialidade buscarPor(int id) {
        return entityManager.find(Especialidade.class,id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Collection<Especialidade> buscarTodos() {
            return entityManager.createQuery("from Especialidade e").getResultList();
    }

    @Override
    public void remover(Integer id) {
        entityManager.remove(entityManager.getReference(Especialidade.class,id));
    }
}
