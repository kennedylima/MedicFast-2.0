package br.com.medicfast.Especialidade;

import java.util.Collection;

public interface EspecialidadeRepository {
    void salvar(Especialidade especialidade);

    Especialidade buscarPor(int id);

    Collection<Especialidade> buscarTodos();

    void remover(Integer id);
}
