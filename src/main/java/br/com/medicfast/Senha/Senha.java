package br.com.medicfast.Senha;

import br.com.medicfast.EntidadeBase.EntidadeBase;
import br.com.medicfast.Ocorrencia.Ocorrencia;
import br.com.medicfast.PontoDeAtendimento.PontoDeAtendimento;
import br.com.medicfast.Utils.Horario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.sql.Time;

@Entity
public class Senha extends EntidadeBase implements Serializable {

    @Column
    public Integer numero;

    @OneToOne
    public PontoDeAtendimento pontoDeAtendimento;

    @Column
    public Ocorrencia ocorrencia;

    @Column
    public Time horarioDeAtendimento;

    public Integer getNumero() {
        return numero;
    }

    public Ocorrencia getOcorrencia() {
        return ocorrencia;
    }
}
