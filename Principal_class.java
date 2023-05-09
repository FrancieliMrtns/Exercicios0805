package Exercicios0805;

import java.util.Scanner;

public class Principal_class {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Digite o nome do titular da conta:");
        String nomeTitular = input.nextLine();
        System.out.println("Digite o número da conta:");
        int numeroConta = input.nextInt();
        System.out.println("Digite o saldo inicial da conta:");
        double saldo = input.nextDouble();
        
        System.out.println("Digite a senha do cartão:");
        String senha = input.next();
        Cartao cartao = new Cartao(senha);
        
        Conta conta = new Conta(nomeTitular, numeroConta, saldo, cartao);
        
        // Menu
        int opcao;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Depósito");
            System.out.println("2 - Retirada");
            System.out.println("3 - Consultar saldo");
            System.out.println("4 - Alterar senha");
            System.out.println("5 - Sair");
            
            opcao = input.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Digite o valor a ser depositado:");
                    double valorDeposito = input.nextDouble();
                    System.out.println("Digite a senha do cartão:");
                    String senhaDeposito = input.next();
                    if (cartao.verificaSenha(senhaDeposito)) {
                        conta.depositar(valorDeposito);
                        System.out.println("Depósito realizado com sucesso.");
                    } else {
                        System.out.println("Senha incorreta. Depósito não realizado.");
                    }
                    break;
                    
                case 2:
                    System.out.println("Digite o valor a ser retirado:");
                    double valorRetirada = input.nextDouble();
                    System.out.println("Digite a senha do cartão:");
                    String senhaRetirada = input.next();
                    if (cartao.verificaSenha(senhaRetirada)) {
                        if (conta.retirar(valorRetirada)) {
                            System.out.println("Retirada realizada com sucesso.");
                        } else {
                            System.out.println("Saldo insuficiente. Retirada não realizada.");
                        }
                    } else {
                        System.out.println("Senha incorreta. Retirada não realizada.");
                    }
                    break;
                    
                case 3:
                    System.out.println("Saldo atual: R$" + conta.consultarSaldo());
                    break;
                    
                case 4:
                    System.out.println("Digite a senha atual:");
                    String senhaAtual = input.next();
                    System.out.println("Digite a nova senha:");
                    String novaSenha1 = input.next();
                    System.out.println("Confirme a nova senha:");
                    String novaSenha2 = input.next();
                    if (cartao.verificaSenha(senhaAtual) && novaSenha1.equals(novaSenha2)) {
                        cartao.alteraSenha(novaSenha1);
                        System.out.println("Senha alterada com sucesso.");
                    } else {
                        System.out.println("Senha atual incorreta ou nova senha inválida. Senha não alterada.");
                    }
                    break;
                    
                case 5:
                    System.out.println("Encerrando o programa...");
                    break;
                    
                default:
                    System.out.println("Opção inválida. Digite uma opção válida.");
                    break;
            }
            
            System.out.println();
        } while (opcao != 5);
        
        input.close();
    }
}