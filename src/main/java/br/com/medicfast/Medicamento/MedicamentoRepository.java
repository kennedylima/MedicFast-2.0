package br.com.medicfast.Medicamento;

import java.util.Collection;

public interface MedicamentoRepository {
    void salvar(Medicamento medicamento);

    Collection<Medicamento> buscarTodos();

    Medicamento buscarPor(Integer id);

    void remover(Integer id);
}
