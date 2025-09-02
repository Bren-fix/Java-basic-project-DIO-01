# 🏦 Desafio de Projeto - Banco Digital em Java

Este projeto foi desenvolvido como parte do **Bootcamp da DIO**, no módulo de **Programação Orientada a Objetos (POO) com Java**.  
O objetivo foi aplicar os **4 pilares da POO**: **Abstração, Encapsulamento, Herança e Polimorfismo**.

---

## 📚 Conceitos Aplicados

- **Abstração**: a classe `Conta` foi criada como abstrata, representando o conceito genérico de uma conta bancária.  
- **Encapsulamento**: os atributos foram definidos como `private` e acessados via getters e métodos controlados.  
- **Herança**: `ContaCorrente` e `ContaPoupanca` herdam de `Conta`.  
- **Polimorfismo**: o método `imprimirExtrato()` foi sobrescrito para comportamentos diferentes em cada tipo de conta.  

---

## ⚙️ Estrutura do Projeto

- `Cliente` → representa o cliente do banco.  
- `Conta` (abstrata) → define operações comuns (sacar, depositar, transferir).  
- `ContaCorrente` → herda de `Conta`.  
- `ContaPoupanca` → herda de `Conta`.  
- `Banco` → gerencia as contas criadas.  
- `Main` → classe de execução do programa (simulação).  

---

## ▶️ Como Executar

1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/nome-do-repositorio.git
