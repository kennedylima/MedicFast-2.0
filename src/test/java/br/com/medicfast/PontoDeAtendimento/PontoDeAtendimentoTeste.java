package br.com.medicfast.PontoDeAtendimento;

import br.com.medicfast.Especialidade.Especialidade;
import br.com.medicfast.Medico.Medico;
import br.com.medicfast.Medico.MedicoRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:springbeanstest.xml")
public class PontoDeAtendimentoTeste extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private PontoDeAtendimentoRepository pontoDeAtendimentoRepository;

    @Autowired
    private MedicoRepository medicoRepository;
    private PontoDeAtendimento pontoDeAtendimento;
    private Medico medico;

    @Test
    public  void deve_salvar_um_ponto_de_atendimento(){
        salvarUmPontoDeAtendimento();
        assertNotNull(pontoDeAtendimento.getId());
    }

    @Test
    public void deve_buscar_todos_os_pontos_de_atendimento(){
        int quantidadeEsperada = 1;
        salvarUmPontoDeAtendimento();
        Collection<PontoDeAtendimento> pontoDeAtendimentoCollection = pontoDeAtendimentoRepository.buscarTodos();

        assertTrue(pontoDeAtendimentoCollection.size() == quantidadeEsperada);
    }

    @Test
    public void deve_ser_possivel_adicionar_uma_lista_de_medicos_ao_ponto_de_atendimento(){
        salvarUmMedico();
        salvarUmPontoDeAtendimento();

        List<Medico> medicos = new ArrayList<Medico>();
        medicos.add(medico);
        pontoDeAtendimento.setMedicos(medicos);
        pontoDeAtendimentoRepository.salvar(pontoDeAtendimento);

        assertNotNull(pontoDeAtendimento.getMedicos());

    }

    private void salvarUmPontoDeAtendimento(){
        pontoDeAtendimento = new PontoDeAtendimento("UBS Estrela Do Sul","Rua Hamlet",1, "Campo Grande", "MS","(67) 3314-3175");
        pontoDeAtendimentoRepository.salvar(pontoDeAtendimento);
    }
    private void salvarUmMedico(){
        medico = new Medico();
        medico.nome = "Dr. Cesar";
        medico.crm = "11342";
        medico.telefone = "67 99999-9098";
        Especialidade especialidade = new Especialidade("Pediatra");

        List<Especialidade> especialidades = new ArrayList<Especialidade>();
        especialidades.add(especialidade);
        medico.especialidade = especialidades;
        medicoRepository.salvar(medico);
    }

}
