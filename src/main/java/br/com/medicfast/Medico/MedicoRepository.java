package br.com.medicfast.Medico;

import java.util.Collection;

public interface MedicoRepository {
    void salvar(Medico medico);

    Collection<Medico> buscarTodos();

    void remover(Integer id);

    Medico buscarPor(Integer id);

}
