
// ------------------------------------------------------------------------------
// |Renan Felipi Saran Pedrao - RGM 27949168                                    |
// ------------------------------------------------------------------------------

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<Pessoa> clientes = new ArrayList<Pessoa>();
        ArrayList<Banco> contas = new ArrayList<Banco>();
        Scanner leia = new Scanner(System.in);

        int opc = 0;
        char continua = 'N';

        System.out.println("----------<<< Bem-Vindo ao Banco Seu Dinheiro é Nosso >>>----------\n");
        System.out.println("Escolha uma das opções abaixo: ");

        do {
            System.out.println("\n1- Cadastrar Cliente");
            System.out.println("2- Cadastrar Conta");
            System.out.println("3- Consultar Saldo");
            System.out.println("4- Exibir Contas");
            System.out.println("5- Sacar dinheiro");
            System.out.println("6- Depositar Dinheiro");
            System.out.println("7- Sair");

            opc = leia.nextInt();

            switch (opc) {
                case 1:

                    System.out.println("Digite o nome do cliente:");
                    String nome = leia.next();

                    System.out.println("Digite o CPF:");
                    String cpf = leia.next();

                    Pessoa p1 = new Pessoa(nome, cpf);
                    System.out.println("------------------------------------------------------\n" +
                            "Cliete Cadastrado com sucesso\n" +
                            "------------------------------------------------------");

                    clientes.add(p1);

                    break;

                case 2:
                    System.out.println("Digite o numero da conta:");
                    int numeroConta = leia.nextInt();

                    System.out.println("Digite o saldo inicial:");
                    double saldo = leia.nextDouble();

                    do {
                        System.out.println("Digite o CPF do titular:");
                        cpf = leia.next();

                        Pessoa titular = null;

                        for (Pessoa c : clientes) {
                            if (c.getCpf().equals(cpf)) {
                                titular = c;
                                break;
                            }
                        }

                        if (titular != null) {
                            Banco conta = new Banco(titular, numeroConta, saldo);
                            contas.add(conta);
                            System.out.println("------------------------------------------------------\n" +
                                    "Conta cadastrada com sucesso\n" +
                                    "------------------------------------------------------");
                            continua = 'N';
                        } else {
                            System.out.println("------------------------------------------------------\n" +
                                    "Titular (CPF) não existe na base de dados\n" +
                                    "------------------------------------------------------");
                            System.out.println("Deseja tentar novamente (S/N)?");
                            continua = leia.next().toUpperCase().charAt(0);
                        }
                    } while (continua == 'S');

                    break;

                case 3:

                    if (contas.size() != 0) {
                        System.out.println("Digite o numero da conta: ");
                        numeroConta = leia.nextInt();
                        for (Banco b : contas) {
                            if (b.getNumeroDaConta() == numeroConta) {
                                System.out.println("Saldo atual:" + b.getSaldo());
                                break;
                            } else {
                                System.out.println("Não foi possivel localizar a conta na base de dados");
                            }
                        }

                    } else {
                        System.out.println("Não existe contas cadastradas!");
                    }

                    break;

                case 4:

                    if (contas.size() != 0) {
                        System.out.println("Titular   |   Conta");
                        for (Banco c1 : contas) {
                            System.out.println(c1.getCliente().nome + "      " + c1.numeroDaConta);
                        }
                    } else {
                        System.out.println("Não existe contas cadastradas!");
                    }

                    break;

                case 5:
                    System.out.println("Digite o numero da conta: ");
                    numeroConta = leia.nextInt();

                    for (Banco saque : contas) {
                        if (saque.getNumeroDaConta() == numeroConta) {
                            System.out.println("Digite o valor que deseja sacar: ");
                            double valor = leia.nextDouble();
                            saque.sacar(valor);
                            break;
                        } else {
                            System.out.println("Não foi possivel localizar a conta na base de dados");
                        }
                    }

                    break;

                case 6:

                    System.out.println("Digite o numero da conta: ");
                    numeroConta = leia.nextInt();

                    for (Banco deposito : contas) {
                        if (deposito.getNumeroDaConta() == numeroConta) {
                            System.out.println("Digite o valor que deseja depositar: ");
                            double valor = leia.nextDouble();
                            deposito.depositar(valor);
                            break;
                        } else {
                            System.out.println("Não foi possivel localizar a conta na base de dados");
                        }
                    }

                    break;

                case 7:

                    break;

                default:
                    System.out.println("Opção invalida! - Verifique as opções dispniveis no menu");
            }

        } while (opc != 7);

    }

}
