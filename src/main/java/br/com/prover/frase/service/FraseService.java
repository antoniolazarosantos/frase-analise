package br.com.prover.frase.service;

import br.com.prover.frase.model.PalavraInfo;
import javax.enterprise.context.ApplicationScoped;
import java.util.*;

@ApplicationScoped
public class FraseService {

    public Map<String, PalavraInfo> analisarFrase(String frase) {
        Map<String, PalavraInfo> resultado = new HashMap<>();
        if (frase == null || frase.trim().isEmpty()) return resultado;

        StringBuilder sb = new StringBuilder();
        for (char c : frase.toCharArray()) {
            if (Character.isLetterOrDigit(c) || Character.isSpaceChar(c)) {
                sb.append(c);
            }
        }

        String[] palavras = sb.toString().toLowerCase().split(" ");
        for (String palavra : palavras) {
            if (!palavra.trim().isEmpty()) {
                resultado.compute(palavra, (k, v) -> v == null ? new PalavraInfo(palavra, 1) : v.incrementar());
            }
        }

        return resultado;
    }
}
