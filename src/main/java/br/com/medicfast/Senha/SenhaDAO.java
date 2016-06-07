package br.com.medicfast.Senha;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;

@Repository
@Transactional
public class SenhaDAO implements SenhaRepository{

    @PersistenceContext
    private EntityManager entityManager;

    public SenhaDAO() {
    }

    public SenhaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void salvar(Senha senha) {
        this.entityManager.persist(senha);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Collection<Senha> buscarTodas() {
        return entityManager.createQuery("from Senha s").getResultList();
    }

    @Override
    public Senha buscarPor(Integer id) {
        return entityManager.find(Senha.class,id);
    }
}

