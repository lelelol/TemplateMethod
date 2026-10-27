package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssinaturaStreamingPremiumTest {

    @Test
    void deveRetornarDesconto30Porcento() {
        AssinaturaStreamingPremium assinatura = new AssinaturaStreamingPremium();
        assertEquals(0.30f, assinatura.getDesconto());
    }

    @Test
    void deveRetornarCabeNoSeuBolso() {
        AssinaturaStreamingPremium assinatura = new AssinaturaStreamingPremium();
        assinatura.setValor(100f);
        assertEquals("Cabe no seu bolso!", assinatura.conseguePagarAssinatura(70f));
    }

    @Test
    void deveRetornarTenteUmaAssinaturaMaisEmConta() {
        AssinaturaStreamingPremium assinatura = new AssinaturaStreamingPremium();
        assinatura.setValor(100f);
        assertEquals("Tente uma assinatura mais em conta!", assinatura.conseguePagarAssinatura(69.9f));
    }

    @Test
    void deveLancarExcecaoPrecoMaximoInvalido() {
        AssinaturaStreamingPremium assinatura = new AssinaturaStreamingPremium();
        assinatura.setValor(100f);
        assertThrows(IllegalArgumentException.class, () -> assinatura.conseguePagarAssinatura(0f));
        assertThrows(IllegalArgumentException.class, () -> assinatura.conseguePagarAssinatura(-10f));
    }
}
