package Exercicios0805;

public class Conta {
    private String nome;
    private int numero;
    private double saldo;
    private Cartao cartao;

    public Conta(String nome, int numero, double saldo, Cartao cartao) {
        this.nome = nome;
        this.numero = numero;
        this.saldo = saldo;
        this.cartao = cartao;
    }

    public boolean depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            return true;
        }
        return false;
    }

    public boolean retirar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public double consulta_saldo() {
        return saldo;
    }
}