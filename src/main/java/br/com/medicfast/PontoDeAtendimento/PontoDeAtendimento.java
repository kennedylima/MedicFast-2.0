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
    private  String nome;

    @Column
    private  String rua;

    @Column
    private  int numero;

    @Column
    private  String cidade;

    @Column
    private  String uf;

    @Column
    private  String telefone;

    @OneToMany
    private Collection<Medico> medicos;

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

    public void adicionarMedicos(Collection<Medico> medicos) {
        this.medicos = medicos;
    }

    public  void alterar(String nome){
        this.nome = nome;
    }

    public void alterarEndereco(String rua, int numero, String cidade, String uf){
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.uf = uf;
    }

    public String getNome() {
        return nome;
    }

    public String getRua() {
        return rua;
    }

    public int getNumero() {
        return numero;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }

    public String getTelefone() {
        return telefone;
    }

    public Collection<Medico> getMedicos() {
        return medicos;
    }
}
