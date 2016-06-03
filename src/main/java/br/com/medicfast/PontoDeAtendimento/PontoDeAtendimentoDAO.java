package br.com.medicfast.PontoDeAtendimento;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;

@Repository
@Transactional
public class PontoDeAtendimentoDAO implements  PontoDeAtendimentoRepository{

    @PersistenceContext
    private EntityManager entityManager;


    public PontoDeAtendimentoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public PontoDeAtendimentoDAO() {
    }

    @Override
    public void salvar(PontoDeAtendimento pontoDeAtendimento) {
        this.entityManager.persist(pontoDeAtendimento);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Collection<PontoDeAtendimento> buscarTodos() {
        return entityManager.createQuery("from PontoDeAtendimento p").getResultList();
    }
}
