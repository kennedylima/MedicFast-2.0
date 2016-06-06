package br.com.medicfast.Medico;

import java.util.Collection;

public interface MedicoRepository {
    void salvar(Medico medico);

    Collection<Medico> buscarTodos();

    void remover(Medico medicoParaRemover);

    Medico buscarPor(Integer id);

}
