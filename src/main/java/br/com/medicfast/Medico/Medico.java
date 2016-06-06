package br.com.medicfast.Medico;

import br.com.medicfast.EntidadeBase.EntidadeBase;
import br.com.medicfast.Especialidade.Especialidade;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;

@Entity
public class Medico extends  EntidadeBase  implements Serializable {
    private String nome;
    private String crm;
    private String telefone;

    @ManyToMany
    private List<Especialidade> especialidade;

    public Medico() {
    }

    public Medico(String nome, String crm, String telefone, List<Especialidade> especialidade) {
        this.nome = nome;
        this.crm = crm;
        this.telefone = telefone;
        this.especialidade = especialidade;
    }

    public void alterar(String nome, String crm, String telefone){
        this.nome = nome;
        this.crm = crm;
        this.telefone = telefone;
    }

    public void adicionarEspecialidade(List<Especialidade> especialidade) {
        this.especialidade = especialidade;
    }

    public String getNome() {
        return nome;
    }

    public String getCrm() {
        return crm;
    }

    public String getTelefone() {
        return telefone;
    }

    public List<Especialidade> getEspecialidade() {
        return especialidade;
    }
}
