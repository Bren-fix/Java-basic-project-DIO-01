import java.util.ArrayList;
import java.util.List;

// ----------------------
// Abstração + Encapsulamento
// ----------------------
class Cliente {
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

// ----------------------
// Classe Abstrata (Abstração)
// ----------------------
abstract class Conta {
    private static int SEQUENCIAL = 1;

    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public void transferir(double valor, Conta destino) {
        if (saldo >= valor) {
            this.sacar(valor);
            destino.depositar(valor);
        } else {
            System.out.println("Transferência não realizada: saldo insuficiente!");
        }
    }

    public abstract void imprimirExtrato();

    protected void imprimirInfosComuns() {
        System.out.println("Titular: " + cliente.getNome());
        System.out.println("Número da conta: " + numero);
        System.out.println("Saldo: R$ " + saldo);
    }
}

// ----------------------
// Herança + Polimorfismo
// ----------------------
class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirInfosComuns();
    }
}

class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        super.imprimirInfosComuns();
    }
}

// ----------------------
// Classe Banco
// ----------------------
class Banco {
    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void listarContas() {
        System.out.println("=== Contas do banco " + nome + " ===");
        for (Conta c : contas) {
            c.imprimirExtrato();
            System.out.println("----------------------");
        }
    }
}

// ----------------------
// Classe Main (Teste)
// ----------------------
public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco("Banco DIO");

        Cliente cliente1 = new Cliente("Breno");
        Conta cc = new ContaCorrente(cliente1);
        Conta poupanca = new ContaPoupanca(cliente1);

        banco.adicionarConta(cc);
        banco.adicionarConta(poupanca);

        cc.depositar(1000);
        cc.transferir(300, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

        banco.listarContas();
    }
}

