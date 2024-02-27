/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vainubank;

/**
 * Classe que representa uma conta corrente. Estende a classe Conta e implementa
 * a interface ContaBancaria.
 *
 * Características principais: - Permite acesso e modificação do limite de
 * crédito da conta. - Implementa métodos para sacar, depositar e transferir
 * dinheiro, conforme especificado na interface ContaBancaria. - Permite que o
 * saldo fique negativo até o valor do limite de crédito.
 */
public class ContaCorrente extends Conta {

    private double limiteCredito; // Limite de crédito associado à conta corrente

    /**
     * Construtor da classe ContaCorrente.
     *
     * @param numero O número da conta.
     * @param agencia O número da agência.
     * @param nomeTitular O nome do titular da conta.
     * @param cpfTitular O CPF do titular da conta.
     * @param limiteCredito O limite de crédito da conta.
     */
    public ContaCorrente(String numero, String agencia, String nomeTitular, String cpfTitular, double limiteCredito) {
        super(numero, agencia, nomeTitular, cpfTitular);
        this.limiteCredito = limiteCredito;
    }

    // Método para pegar o número da Conta Bancária
    @Override
    public String getNumero() {
        return this.numero;
    }
    // Método para pegar o nome do Titular da Conta
    @Override
    public String getNomeTitular() {
        return this.nomeTitular;
    }
    
    // Método para pegar a Agência
    @Override
    public String getAgencia() {
        return this.agencia;
    }
    
    @Override
    public String getCpfTitular() {
        return this.cpfTitular;
    }

    /**
     * Método para acessar o limite de crédito da conta.
     *
     * @return O limite de crédito da conta.
     */
    public double getLimiteCredito() {
        return limiteCredito;
    }

    /**
     * Método para definir o limite de crédito da conta.
     *
     * @param limiteCredito O novo limite de crédito da conta.
     */
    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    /**
     * Método para sacar dinheiro da conta corrente. Verifica se o saldo mais o
     * limite de crédito são suficientes para cobrir o saque.
     *
     * @param valor O valor a ser sacado.
     * @throws SaldoInsuficienteException Se o saldo e o limite de crédito forem
     * insuficientes para realizar o saque.
     */
    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor > (getSaldo() + limiteCredito)) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar o saque.");
        } else {
            saldo -= valor;
        }
    }

    /**
     * Método para depositar dinheiro na conta corrente.
     *
     * @param valor O valor a ser depositado.
     */
    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    /**
     * Método para transferir dinheiro de uma conta corrente para outra conta
     * bancária.
     *
     * @param destino A conta bancária de destino.
     * @param valor O valor a ser transferido.
     * @throws SaldoInsuficienteException Se o saldo e o limite de crédito forem
     * insuficientes para realizar a transferência.
     */
    @Override
    public void transferir(ContaBancaria destino, double valor) throws SaldoInsuficienteException {
        if (valor > (getSaldo() + limiteCredito)) {
            throw new SaldoInsuficienteException("Saldo e limite de crédito insuficientes para realizar a transferência.");
        } else {
            saldo -= valor;
            destino.depositar(valor);
        }

    }
}
