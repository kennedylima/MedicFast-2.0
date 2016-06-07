package br.com.medicfast.Senha;

import br.com.medicfast.EntidadeBase.EntidadeBase;
import br.com.medicfast.Ocorrencia.Ocorrencia;
import br.com.medicfast.PontoDeAtendimento.PontoDeAtendimento;
import br.com.medicfast.Utils.Horario;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.NaturalId;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

import static org.hibernate.id.SequenceGenerator.SEQUENCE;

@Entity
public class Senha extends EntidadeBase implements Serializable {

    @Column
    private Integer numero ;

    @OneToOne
    private PontoDeAtendimento pontoDeAtendimento;

    @Column
    private Ocorrencia ocorrencia;

    @Column
    private Time horarioDeAtendimento;

    private static Integer numeroDaSenha = 0;

    public Senha() {
    }

    public Senha(PontoDeAtendimento pontoDeAtendimento, Ocorrencia ocorrencia, Time horarioDeAtendimento) {
        this.pontoDeAtendimento = pontoDeAtendimento;
        this.ocorrencia = ocorrencia;
        this.horarioDeAtendimento = horarioDeAtendimento;
        gerarNumero();
    }

    public Integer getNumero() {
        return numero;
    }

    public Ocorrencia getOcorrencia() {
        return ocorrencia;
    }

    private void gerarNumero(){
        this.numero = ++numeroDaSenha;
    }

}
