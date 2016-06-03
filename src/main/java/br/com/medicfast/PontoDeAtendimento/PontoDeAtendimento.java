package br.com.medicfast.PontoDeAtendimento;

import br.com.medicfast.EntidadeBase.EntidadeBase;
import br.com.medicfast.Medico.Medico;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
public class PontoDeAtendimento extends EntidadeBase implements Serializable {

    @Column
    public  String nome;

    @Column
    public  String rua;

    @Column
    public  int numero;

    @Column
    public  String cidade;

    @Column
    public  String uf;

    @Column
    public  String telefone;

    @OneToMany
    public Collection<Medico> medicos;

    public PontoDeAtendimento(String nome, String rua, int numero, String cidade, String uf, String telefone) {
        this.nome = nome;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.uf = uf;
        this.telefone = telefone;

    }


    public PontoDeAtendimento() {
    }

    public void setMedicos(Collection<Medico> medicos) {
        this.medicos = medicos;
    }


    public Collection<Medico> getMedicos() {
        return medicos;
    }
}
