/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vainubank;

/**
 *
 * @author sherlocod3
 */
public class SaldoInsuficienteException extends Exception {

    // Construtor padrão
    public SaldoInsuficienteException() {
        super("Saldo insuficiente para realizar a operação.");
    }

    // Construtor com mensagem personalizada
    public SaldoInsuficienteException(String mensagem) {
        super(mensagem);
    }
}
