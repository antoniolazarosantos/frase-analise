package br.com.prover.frase.model;

public class PalavraInfo {
    private String palavra;
    private int ocorrencias;

    public PalavraInfo(String palavra, int ocorrencias) {
        this.palavra = palavra;
        this.ocorrencias = ocorrencias;
    }

    public PalavraInfo incrementar() {
        this.ocorrencias++;
        return this;
    }

    public String getPalavra() { return palavra; }
    public int getOcorrencias() { return ocorrencias; }
}
