package br.com.medicfast.Medicamento;

import br.com.medicfast.EntidadeBase.EntidadeBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Medicamento extends EntidadeBase implements Serializable{

    @Column
    private  String nome;

    @Column
    private  int quantidade;

    public Medicamento() {
    }

    public Medicamento(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void alterar(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }
}
