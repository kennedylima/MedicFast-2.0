package br.com.medicfast.Medicamento;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:springbeanstest.xml")
public class MedicamentoTeste extends AbstractTransactionalJUnit4SpringContextTests{

    @Autowired
    private MedicamentoRepository medicamentoRepository;
    private Medicamento medicamento;
    List<Medicamento> medicamentos;


    @Test
    public void deve_salvar_um_medicamento(){
        salvarMedicamento();
        assertNotNull(medicamento.getId());

    }

    @Test
    public void deve_buscar_todos_os_medicamentos(){
        int quantidadeEsperada = 2;
        salvarMedicamento();
        salvarMedicamento();

        medicamentos = (List<Medicamento>) medicamentoRepository.buscarTodos();

        assertEquals(quantidadeEsperada, medicamentos.size());
    }

    @Test
    public void deve_buscar_um_medicamento_pelo_id(){
        Medicamento medicamentoRetornado;
        salvarMedicamento();

        medicamentoRetornado = medicamentoRepository.buscarPor(medicamento.getId());

        assertEquals(medicamentoRetornado, medicamento);
    }

    @Test
    public void deve_alterar_um_medicamento(){
        salvarMedicamento();
        String nome = "Paracetamol";
        int quantidade = 150;
        medicamento = medicamentoRepository.buscarPor(medicamento.getId());

        medicamento.alterar(nome,quantidade);
        medicamentoRepository.salvar(medicamento);

        assertEquals(nome,medicamento.getNome());
        assertEquals(quantidade,medicamento.getQuantidade());
    }

    @Test
    public void deve_remover_um_medicamento(){
        salvarMedicamento();
        salvarMedicamento();
        medicamentos = (List<Medicamento>) medicamentoRepository.buscarTodos();

        medicamentoRepository.remover(medicamento.getId());
        medicamentos = (List<Medicamento>) medicamentoRepository.buscarTodos();

        assertThat(medicamentos, not(contains(medicamento)));

    }

    private void salvarMedicamento(){
        String nome = "Dipirona";
        int quantidade = 10;
        medicamento = new Medicamento(nome,quantidade);

        medicamentoRepository.salvar(medicamento);
    }

}
