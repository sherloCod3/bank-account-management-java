/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vainubank;

/**
 *
 * @author sherlocod3
 */
public class Conta implements ContaBancaria {

    String numero;
    String agencia;
    String nomeTitular;
    String cpfTitular;
    double saldo;

    // Construtor
    public Conta(String numero, String agencia, String nomeTitular, String cpfTitular) {
        this.numero = numero;
        this.agencia = agencia;
        this.nomeTitular = nomeTitular;
        this.cpfTitular = cpfTitular;
        this.saldo = 0.0; // saldo inicial é zero
    }

    // Implementação dos métodos da interface ContaBancaria

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar o saque.");
        }
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(ContaBancaria destino, double valor) throws SaldoInsuficienteException {
        sacar(valor); // saca da conta atual
        destino.depositar(valor); // deposita na conta de destino
    }

    @Override
    public double getSaldo() {
        return saldo;
    }

    @Override
    public String getNumero() {
        return numero;
    }

    @Override
    public String getNomeTitular() {
        return nomeTitular;
    }
    
    @Override
    public String getAgencia() {
        return agencia;
    }
    
    @Override
    public String getCpfTitular() {
        return cpfTitular;
    }
    
    // Implementação dos métodos de modificação da conta

    @Override
    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    @Override
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    @Override
    public void setCpfTitular(String cpfTitular) {
        this.cpfTitular = cpfTitular;
    }
}
