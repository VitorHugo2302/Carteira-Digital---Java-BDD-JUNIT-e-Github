
package br.com.una.steps;

import br.com.una.CarteiraDigital;

import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.E;

import static org.junit.jupiter.api.Assertions.*;

public class CarteiraDigitalSteps {

    private CarteiraDigital carteira;
    private boolean operacaoRecusada;

    @Before
    public void configurar() {
        carteira = new CarteiraDigital();
        operacaoRecusada = false;
    }

    @Dado("que minha carteira digital está com saldo zero")
    public void carteiraComSaldoZero() {
        // A carteira começa com saldo zero.
    }

    @Dado("que minha carteira digital está com saldo de {double} reais")
    public void carteiraComSaldo(double valor) {
        carteira.depositar(valor);
    }

    @Quando("eu deposito {double} reais")
    public void deposito(double valor) {
        carteira.depositar(valor);
    }

    @Quando("eu pago {double} reais")
    public void pagamento(double valor) {
        carteira.pagar(valor);
    }

    @Quando("eu tento pagar {double} reais")
    public void tentarPagamento(double valor) {
        try {
            carteira.pagar(valor);
        } catch (IllegalArgumentException e) {
            operacaoRecusada = true;
        }
    }

    @Entao("o saldo da carteira deve ser {double} reais")
    public void verificarSaldo(double valor) {
        assertEquals(
            valor,
            carteira.consultarSaldo(),
            0.001
        );
    }

    @Entao("a operação deve ser recusada")
    public void verificarOperacaoRecusada() {
        assertTrue(operacaoRecusada);
    }

    @E("o saldo da carteira deve continuar em {double} reais")
    public void verificarSaldoMantido(double valor) {
        assertEquals(
            valor,
            carteira.consultarSaldo(),
            0.001
        );
    }
}
