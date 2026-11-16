#language: pt

Funcionalidade: Carteira Digital

    Como usuário de uma carteira Digital
    Quero realizar depósitos e pagamentos
    Para controlar meu dinheiro

    Cenário: Realizar depósito de cem reais
        Dado que minha carteira digital está com saldo zero
        Quando eu deposito 100 reais
        Então o saldo da carteira deve ser 100 reais

    Cenário: Realizar pagamento de quarenta reais
        Dado que minha carteira está com sdaldo de 100 reais
        Quando eu pago 40 reais
        Então o saldo da carteira deve ser 60 reais

    Cenário: Impedir pagamento maior que o saldo
        Dado que minha carteira digital está com saldfo de 100 reais
        Quando eu tento pagar 120 reais
        Então a operação deve ser recusada
        E o saldo da carteira deve continuar em 100 reais