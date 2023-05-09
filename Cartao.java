package Exercicios0805;
import java.util.Scanner;

public class Cartao {
    private String senha;

    public Cartao(String senha) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a senha do cartão: ");
        String senhaConfirmacao = sc.nextLine();

        while(!senha.equals(senhaConfirmacao)) {
            System.out.println("Senhas não coincidem. Digite a senha do cartão novamente: ");
            senha = sc.nextLine();
            System.out.println("Confirme a senha do cartão: ");
            senhaConfirmacao = sc.nextLine();
        }

        this.senha = senha;
        System.out.println("Senha cadastrada com sucesso!");
    }

    public boolean verificaSenha() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a senha do cartão: ");
        String senhaDigitada = sc.nextLine();

        if(senha.equals(senhaDigitada)) {
            return true;
        }
        else {
            System.out.println("Senha incorreta.");
            return false;
        }
    }

    public void alteraSenha() {
        if(verificaSenha()) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite a nova senha: ");
            String novaSenha = sc.nextLine();

            System.out.println("Confirme a nova senha: ");
            String novaSenhaConfirmacao = sc.nextLine();

            if(senha.equals(novaSenha)) {
                System.out.println("A nova senha deve ser diferente da senha atual.");
                return;
            }

            if(novaSenha.equals(novaSenhaConfirmacao)) {
                senha = novaSenha;
                System.out.println("Senha alterada com sucesso!");
            }
            else {
                System.out.println("Erro ao alterar a senha. Verifique as informações digitadas.");
            }
        }
    }
}