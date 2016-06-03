package br.com.medicfast.Senha;

import java.util.Collection;

public interface SenhaRepository {
    void salvar(Senha senha);
    Collection<Senha> buscarTodas();
}
