package br.com.prover.frase.controller;

import br.com.prover.frase.model.PalavraInfo;
import br.com.prover.frase.service.FraseService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Named
@ViewScoped
public class FraseController implements Serializable {
    private static final long serialVersionUID = 1L;
    private String frase;
    private Map<String, PalavraInfo> resultado;

    @Inject
    private FraseService service;

    public void analisar() {
        resultado = service.analisarFrase(frase);
    }

    public int getTotalPalavrasDistintas() {
        return resultado != null ? resultado.size() : 0;
    }

    public List<PalavraInfo> getListaResultado() {
        return resultado != null ? new ArrayList<>(resultado.values()) : java.util.Collections.emptyList();
    }


    public String getFrase() { return frase; }
    public void setFrase(String frase) { this.frase = frase; }
    public Map<String, PalavraInfo> getResultado() { return resultado; }
}
