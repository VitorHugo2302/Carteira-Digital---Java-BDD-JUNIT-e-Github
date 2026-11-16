package br.com.una;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarteiraDigitalTest {
    private CarteiraDigital carteira;

    @BeforeEach
    void configurar() {
        carteira = new CarteiraDigital();
    }

    @Test
    void deveDepositarCemReais() {
        carteira.depositar(100);
        assertEquals(100.0, carteira.consultarSaldo(), 0.001);
    }

    @Test
    void devePagarQuarentaReais() {
        carteira.depositar(100);
        carteira.pagar(40);
        assertEquals(60.0, carteira.consultarSaldo(), 0.001);
    }
    @Test
    void deveImpedirPagamentoMaiorQueSaldo() {
        carteira.depositar(100);
        assertThrows(IllegalArgumentException.class, () -> carteira.pagar(120));
        assertEquals(100.0, carteira.consultarSaldo(), 0.001);
    }
}