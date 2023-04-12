// ------------------------------------------------------------------------------
// |Renan Felipi Saran Pedrao - RGM 27949168                                    |
// ------------------------------------------------------------------------------

public class Banco {
    public Pessoa cliente;
    public int numeroDaConta;
    public double saldo;

    public Banco() {

    }

    public Banco(Pessoa titular, int numeroConta, double saldo) {
        this.cliente = titular;
        this.numeroDaConta = numeroConta;
        this.saldo = saldo;

    }

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public int getNumeroDaConta() {
        return numeroDaConta;
    }

    public void setNumeroDaConta(int numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        this.saldo += valor;
        System.out.println("Deposito efetuado com sucesso!\nSaldo Atual: " + this.saldo);
    }

    public void sacar(double valor) {
        if (valor > this.saldo) {
            System.out.println("Saldo insuficiente" + "\nSaldo atual:" + this.saldo);
        } else {
            this.saldo -= valor;
            System.out.println("Saque realiado com sucesso! \nSaldo Atual: " + this.saldo);
        }
    }

}
