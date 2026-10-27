package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssinaturaStreamingBasicaTest {

    @Test
    void deveRetornarDesconto10Porcento() {
        AssinaturaStreamingBasica assinatura = new AssinaturaStreamingBasica();
        assertEquals(0.10f, assinatura.getDesconto());
    }

    @Test
    void deveRetornarCabeNoSeuBolso() {
        AssinaturaStreamingBasica assinatura = new AssinaturaStreamingBasica();
        assinatura.setValor(100f);
        assertEquals("Cabe no seu bolso!", assinatura.conseguePagarAssinatura(90f));
    }

    @Test
    void deveRetornarTenteUmaAssinaturaMaisEmConta() {
        AssinaturaStreamingBasica assinatura = new AssinaturaStreamingBasica();
        assinatura.setValor(100f);
        assertEquals("Tente uma assinatura mais em conta!", assinatura.conseguePagarAssinatura(89.9f));
    }

    @Test
    void deveLancarExcecaoPrecoMaximoInvalido() {
        AssinaturaStreamingBasica assinatura = new AssinaturaStreamingBasica();
        assinatura.setValor(100f);
        assertThrows(IllegalArgumentException.class, () -> assinatura.conseguePagarAssinatura(0f));
        assertThrows(IllegalArgumentException.class, () -> assinatura.conseguePagarAssinatura(-10f));
    }
}
