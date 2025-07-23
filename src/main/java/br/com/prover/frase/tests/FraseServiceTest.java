package br.com.prover.frase.tests;

import br.com.prover.frase.model.PalavraInfo;
import br.com.prover.frase.service.FraseService;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class FraseServiceTest {

    FraseService service = new FraseService();

    @Test
    void deveRetornarContagemCorretaParaFraseSimples() {
        Map<String, PalavraInfo> resultado = service.analisarFrase("O gato e o cachorro");

        assertEquals(3, resultado.size());
        assertEquals(2, resultado.get("o"));
        assertEquals(1, resultado.get("gato"));
        assertEquals(1, resultado.get("e"));
        assertEquals(1, resultado.get("cachorro"));
    }

    @Test
    void deveIgnorarPontuacaoESerCaseInsensitive() {
        Map<String, PalavraInfo> resultado = service.analisarFrase("Olá, olá! Tudo bem?");

        assertEquals(3, resultado.size());
        assertEquals(2, resultado.get("olá"));
        assertEquals(1, resultado.get("tudo"));
        assertEquals(1, resultado.get("bem"));
    }

    @Test
    void deveRetornarMapaVazioParaFraseVazia() {
        Map<String, PalavraInfo> resultado = service.analisarFrase("");

        assertTrue(resultado.isEmpty());
    }

    @Test
    void deveRetornarMapaVazioParaFraseNula() {
        Map<String, PalavraInfo> resultado = service.analisarFrase(null);

        assertTrue(resultado.isEmpty());
    }

    @Test
    void deveLidarComMultiplosEspacos() {
        Map<String, PalavraInfo> resultado = service.analisarFrase("java   java     jsf");

        assertEquals(2, resultado.size());
        assertEquals(2, resultado.get("java"));
        assertEquals(1, resultado.get("jsf"));
    }
}
