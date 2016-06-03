package br.com.medicfast.Ocorrencia;


public enum  Ocorrencia {
    SUSPEITA_DE_DENGUE(20), ACIDENTE(40), VACINA(20), PEGAR_EXAME(10), PEGAR_MEDICACAO(10);

    private int tempoNecessarioParaOAtendimento;

    Ocorrencia(int tempoNecessarioParaOAtendimento){
        this.tempoNecessarioParaOAtendimento = tempoNecessarioParaOAtendimento;
    }

    public int getTempoNecessarioParaOAtendimento() {
        return tempoNecessarioParaOAtendimento;
    }
}
