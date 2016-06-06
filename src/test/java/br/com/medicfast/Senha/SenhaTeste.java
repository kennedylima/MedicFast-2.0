package br.com.medicfast.Senha;

import br.com.medicfast.Ocorrencia.Ocorrencia;
import br.com.medicfast.PontoDeAtendimento.PontoDeAtendimento;
import br.com.medicfast.PontoDeAtendimento.PontoDeAtendimentoRepository;
import br.com.medicfast.Utils.Horario;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import javax.persistence.OneToOne;
import java.sql.Time;
import java.util.Collection;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@ContextConfiguration(locations = "classpath:springbeanstest.xml")
public class SenhaTeste extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private SenhaRepository senhaRepository;

    @Autowired
    private PontoDeAtendimentoRepository pontoDeAtendimentoRepository;
    private Senha senha;
    private PontoDeAtendimento pontoDeAtendimento;

    @Test
    public void deve_salvar_uma_senha(){
        salvarUmaSenha();
        assertNotNull(senha.getNumero());
    }

    @Test
    public void deve_buscar_todas_as_senhas(){
        int quantidadeEsperada = 3;
        Collection<Senha> senhas ;
        salvarUmaSenha();
        salvarUmaSenha();
        salvarUmaSenha();

        senhas = senhaRepository.buscarTodas();

        assertTrue(senhas.size() == quantidadeEsperada);
    }

    private void salvarUmaSenha(){
        salvarUmPontoDeAtedimento();

        Time horarioPrevistoParaOAtendimento = Horario.deAtendimentoPara(Ocorrencia.SUSPEITA_DE_DENGUE);
        senha = new Senha(pontoDeAtendimento,Ocorrencia.SUSPEITA_DE_DENGUE,horarioPrevistoParaOAtendimento);


        senhaRepository.salvar(senha);
        senha.setNumero(senha.getId());
    }

    private void salvarUmPontoDeAtedimento(){
        pontoDeAtendimento = new PontoDeAtendimento("UBS Estrela Do Sul","Rua Hamlet",1, "Campo Grande", "MS","(67) 3314-3175");
        pontoDeAtendimentoRepository.salvar(pontoDeAtendimento);
    }
}
