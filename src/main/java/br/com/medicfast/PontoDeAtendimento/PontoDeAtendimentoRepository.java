package br.com.medicfast.PontoDeAtendimento;

import java.util.Collection;

public interface PontoDeAtendimentoRepository {
    void salvar(PontoDeAtendimento pontoDeAtendimento);

    Collection<PontoDeAtendimento> buscarTodos();
}
