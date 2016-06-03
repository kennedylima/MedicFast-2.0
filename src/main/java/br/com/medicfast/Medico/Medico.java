package br.com.medicfast.Medico;

import br.com.medicfast.EntidadeBase.EntidadeBase;
import br.com.medicfast.Especialidade.Especialidade;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
public class Medico extends  EntidadeBase  implements Serializable {
    public String nome;
    public String crm;
    public String telefone;

    @OneToMany
    public List<Especialidade> especialidade;

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
