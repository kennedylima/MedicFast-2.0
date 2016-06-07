package br.com.medicfast.Especialidade;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.List;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:springbeanstest.xml")
public class EspecialidadeTeste extends AbstractTransactionalJUnit4SpringContextTests{

    @Autowired
    EspecialidadeRepository especialidadeRepository;
    Especialidade especialidade;
    List<Especialidade> especialidades;

    @Before
    public void salvarEspecialidade(){
        especialidade = new Especialidade("Cirurgião Pediatra");
        especialidadeRepository.salvar(especialidade);
    }

    @Test
    public void deve_salvar_uma_especialidade(){
        assertNotNull(especialidade.getId());
    }

    @Test
    public void deve_alterar_uma_especialidade(){
        String nome = "Psiquiatria";

        especialidade.alterar(nome);
        especialidadeRepository.salvar(especialidade);
        especialidade = especialidadeRepository.buscarPor(especialidade.getId());

        assertEquals(nome, especialidade.getNome());
    }

    @Test
    public void deve_buscar_todas_as_especialidades(){
        int quantidadeEsperada = 2;
        salvarEspecialidade();

        especialidades = (List<Especialidade>) especialidadeRepository.buscarTodos();

        assertTrue(especialidades.size() == quantidadeEsperada);

    }

    @Test
    public void deve_buscar_uma_especialidade_pelo_id(){
        int id = 3;
        salvarEspecialidade();
        salvarEspecialidade();
        especialidade = especialidadeRepository.buscarPor(id);

        assertNotNull(especialidade);
    }

    @Test
    public void deve_remover_uma_especialidade(){
        especialidadeRepository.remover(especialidade.getId());
        especialidades = (List<Especialidade>) especialidadeRepository.buscarTodos();

        assertThat(especialidades, not(hasItem(especialidade)));

    }

}
