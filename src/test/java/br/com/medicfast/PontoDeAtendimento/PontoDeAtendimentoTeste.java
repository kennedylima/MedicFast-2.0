package br.com.medicfast.PontoDeAtendimento;

import br.com.medicfast.Especialidade.Especialidade;
import br.com.medicfast.Medico.Medico;
import br.com.medicfast.Medico.MedicoRepository;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:springbeanstest.xml")
public class PontoDeAtendimentoTeste extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private PontoDeAtendimentoRepository pontoDeAtendimentoRepository;

    @Autowired
    private MedicoRepository medicoRepository;
    private PontoDeAtendimento pontoDeAtendimento;
    private Medico medico;

    @Before
    public void salvar_ponto_de_atendimento(){
        salvarUmPontoDeAtendimento();
    }

    @Test
    public  void deve_salvar_um_ponto_de_atendimento(){
        assertNotNull(pontoDeAtendimento.getId());
    }

    @Test
    public void deve_buscar_todos_os_pontos_de_atendimento(){
        int quantidadeEsperada = 1;
        Collection<PontoDeAtendimento> pontoDeAtendimentoCollection = pontoDeAtendimentoRepository.buscarTodos();

        assertTrue(pontoDeAtendimentoCollection.size() == quantidadeEsperada);
    }

    @Test
    public void deve_buscar_um_ponto_de_atendimento_por_id(){
        pontoDeAtendimento = pontoDeAtendimentoRepository.buscarPor(1);

        assertNotNull(pontoDeAtendimento);
    }

    @Test
    public void deve_ser_possivel_adicionar_uma_lista_de_medicos_ao_ponto_de_atendimento(){
        salvarMedicos();

        List<Medico> medicos = new ArrayList<Medico>();
        medicos.add(medico);
        pontoDeAtendimento.adicionarMedicos(medicos);
        pontoDeAtendimentoRepository.salvar(pontoDeAtendimento);


        assertNotNull(pontoDeAtendimento.getMedicos());
    }

    @Test
    public void deve_alterar_o_endereco_de_um_ponto_de_atendimento(){
        String rua = "Rua Hamlet II";
        int numero = 1845;
        String cidade = "Campo Grande";
        String uf = "RJ";

        pontoDeAtendimento.alterarEndereco(rua,numero,cidade,uf);
        pontoDeAtendimentoRepository.salvar(pontoDeAtendimento);

        assertEquals(numero,pontoDeAtendimento.getNumero());
    }

    @Test
    public void deve_alterar_o_nome_de_um_ponto_de_atendimento(){
        String nome = "UPA Conjunto Estrela do Sul";

        pontoDeAtendimento.alterar(nome);
        pontoDeAtendimentoRepository.salvar(pontoDeAtendimento);

        assertEquals(nome,pontoDeAtendimento.getNome());
    }

    @Test
    public  void deve_remover_um_ponto_de_atendimento_com_medicos_adicionados(){
        List<Medico> medicos = new ArrayList<Medico>();
        salvarMedicos();
        pontoDeAtendimento.adicionarMedicos(medicos);

        pontoDeAtendimentoRepository.salvar(pontoDeAtendimento);
        pontoDeAtendimentoRepository.remover(pontoDeAtendimento.getId());
        pontoDeAtendimento = pontoDeAtendimentoRepository.buscarPor(pontoDeAtendimento.getId());

        assertNull(pontoDeAtendimento);
    }

    @Test
    public void deve_remover_um_ponto_de_atendimento(){
        salvarUmPontoDeAtendimento();
        salvarUmPontoDeAtendimento();

        pontoDeAtendimentoRepository.remover(pontoDeAtendimento.getId());
        Collection<PontoDeAtendimento> pontoDeAtendimentoCollection = (List<PontoDeAtendimento>) pontoDeAtendimentoRepository.buscarTodos();

        assertThat(pontoDeAtendimentoCollection, not(hasItem(pontoDeAtendimento)));
    }

    private void salvarUmPontoDeAtendimento(){
        String nome = "UBS Estrela Do Sul";
        String rua = "Rua Hamlet";
        int numero = 1;
        String cidade = "Campo Grande";
        String uf = "MS";
        String telefone = "(67) 3314-3175";

        pontoDeAtendimento = new PontoDeAtendimento(nome,rua,numero,cidade,uf,telefone);
        pontoDeAtendimentoRepository.salvar(pontoDeAtendimento);
    }
    private void salvarMedicos(){

        for(int i =0 ; i> 3; i++) {
            String nome = "Dr. Cesar";
            String crm = "11342";
            String telefone = "67 99999-9098";
            Especialidade especialidade = new Especialidade("Pediatra");

            List<Especialidade> especialidades = new ArrayList<Especialidade>();
            especialidades.add(especialidade);

            medico = new Medico(nome, crm, telefone, especialidades);

            medicoRepository.salvar(medico);
        }
    }

}
