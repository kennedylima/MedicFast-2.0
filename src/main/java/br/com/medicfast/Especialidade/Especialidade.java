package br.com.medicfast.Especialidade;

import br.com.medicfast.EntidadeBase.EntidadeBase;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Especialidade extends EntidadeBase implements Serializable {

    private String nome;

    public Especialidade() {}

    public Especialidade(String nome) {
        this.nome = nome;
    }
}