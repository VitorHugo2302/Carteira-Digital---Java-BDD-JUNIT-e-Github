package br.com.una;

public class CarteiraDigital {

    private double saldo;

    public CarteiraDigital(){
        saldo = 0.0;
    }

    public void depositar(double valor){
        if(valor <= 0) {
            throw new IllegalArgumentException("O depósito deve ser maior que 0");

        }
        saldo += valor;
    }

    public void pagar(double valor){
        if(valor <= 0) {
            throw new IllegalArgumentException("O pagamento deve ser maior que 0");

        }

        if(valor > saldo){
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        saldo -= valor;
    }

    public double consultarSaldo(){
        return saldo;
    }
}