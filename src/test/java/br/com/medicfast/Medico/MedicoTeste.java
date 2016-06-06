package br.com.medicfast.Medico;

import br.com.medicfast.Especialidade.Especialidade;
import br.com.medicfast.Especialidade.EspecialidadeRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:springbeanstest.xml")
public class MedicoTeste extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private MedicoRepository medicoRepository;
    private Medico medico;

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    @Test
    public void deve_salvar_um_medico(){
        salvarMedico();
        assertNotNull(medico.getId());
    }

    @Test
    public void deve_alterar_um_medico(){
        salvarMedico();
        String nome = "Dr. Kennedy";
        String crm = "2722";
        String telefone = "33240736";

        medico.alterar(nome,crm,telefone);
        medicoRepository.salvar(medico);

        assertTrue(medico.getNome() == nome);
    }

    @Test
    public void deve_alterar_as_especialidades_de_um_medico(){
        salvarMedico();
        List<Especialidade> especialidades = new ArrayList<Especialidade>();
        Especialidade cirurgiao = new Especialidade("Cirurgiao");
        especialidades.add(cirurgiao);
        Especialidade dentista = new Especialidade("Dentista");
        especialidades.add(dentista);


        medico.adicionarEspecialidade(especialidades);
        medicoRepository.salvar(medico);


        assertThat(medico.getEspecialidade(), hasItem(cirurgiao));
        assertThat(medico.getEspecialidade(), hasItem(dentista));

    }

    @Test
    public void deve_buscar_todos_os_medicos(){
        int quantidadeEsperada = 3;
        salvarMedico();
        salvarMedico();
        salvarMedico();

        List<Medico> medicos = (List<Medico>)medicoRepository.buscarTodos();

        assertTrue(medicos.size()== quantidadeEsperada);
    }

    @Test
    public void deve_buscar_medico_por_id(){
        salvarMedico();
        salvarMedico();
        Medico medicoEsperado = medico;
        salvarMedico();

        Medico medicoRetornado = medicoRepository.buscarPor(medicoEsperado.getId());

        assertEquals(medicoEsperado,medicoRetornado);
    }

    @Test
    public void deve_remover_um_medico(){
        salvarMedico();
        salvarMedico();

        Collection<Medico> medicoCollection = medicoRepository.buscarTodos();
        medicoRepository.remover(medico);
        medicoCollection = medicoRepository.buscarTodos();

        assertThat(medicoCollection, not(hasItem(medico)));
    }

    private void salvarMedico(){
        String nome = "Dr. Cesar";
        String crm = "11342";
        String telefone = "67 99999-9098";

        List<Especialidade> especialidades = new ArrayList<Especialidade>();
        especialidades.add(getEspecialidade());

        medico = new Medico(nome,crm,telefone,especialidades);

        medicoRepository.salvar(medico);
    }
    private Especialidade getEspecialidade(){
        final Especialidade  especialidade = new Especialidade("Pediatra");
        especialidadeRepository.salvar(especialidade);
        return especialidade;
    }
}
