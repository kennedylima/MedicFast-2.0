package br.com.medicfast.Medicamento;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;

@Repository
@Transactional
public class MedicamentoDAO implements MedicamentoRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void salvar(Medicamento medicamento) {
        entityManager.persist(medicamento);
    }

    @Override
    public Collection<Medicamento> buscarTodos() {
        return entityManager.createQuery("from Medicamento m").getResultList();
    }

    @Override
    public Medicamento buscarPor(Integer id) {
        return entityManager.find(Medicamento.class, id);
    }

    @Override
    public void remover(Integer id) {
        entityManager.remove(entityManager.getReference(Medicamento.class, id));
    }
}
