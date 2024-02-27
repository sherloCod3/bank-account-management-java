/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vainubank;

/**
 *
 * @author sherlocod3
 */
/**
 * Classe que representa uma conta poupança. Estende a classe Conta e implementa
 * a interface ContaBancaria.
 *
 * Características principais: - Permite acesso e modificação do dia de
 * aniversário da conta. - Implementa métodos para sacar, depositar e transferir
 * dinheiro, conforme especificado na interface ContaBancaria. - Aplica uma taxa
 * de juros de 2% sobre o valor do saque na implementação do método sacar().
 */
public class ContaPoupanca extends Conta {

    private int diaAniversario; // Dia de aniversário da conta poupança

    /**
     * Construtor da classe ContaPoupanca.
     *
     * @param numero O número da conta.
     * @param agencia O número da agência.
     * @param nomeTitular O nome do titular da conta.
     * @param cpfTitular O CPF do titular da conta.
     * @param diaAniversario O dia de aniversário da conta.
     */
    public ContaPoupanca(String numero, String agencia, String nomeTitular, String cpfTitular, int diaAniversario) {
        super(numero, agencia, nomeTitular, cpfTitular);
        this.diaAniversario = diaAniversario;
    }

    /**
     * Método para acessar o dia de aniversário da conta.
     *
     * @return O dia de aniversário da conta.
     */
    public int getDiaAniversario() {
        return diaAniversario;
    }

    /**
     * Método para definir o dia de aniversário da conta.
     *
     * @param diaAniversario O novo dia de aniversário da conta.
     */
    public void setDiaAniversario(int diaAniversario) {
        this.diaAniversario = diaAniversario;
    }

    /**
     * Método para sacar dinheiro da conta poupança. Verifica se o saldo é
     * suficiente para cobrir o saque e aplica uma taxa de juros de 2% sobre o
     * valor do saque.
     *
     * @param valor O valor a ser sacado.
     * @throws SaldoInsuficienteException Se o saldo for insuficiente para
     * realizar o saque.
     */
    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor > getSaldo()) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar o saque.");
        } else {
            saldo -= valor + (valor * 0.02); // Aplica taxa de 2% de juros sobre o saque
        }
    }

    /**
     * Método para depositar dinheiro na conta poupança.
     *
     * @param valor O valor a ser depositado.
     */
    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    // Método para pegar o número da Conta Bancária
    @Override
    public String getNumero() {
        return this.numero;
    }
    
    // Método para pegar o número do Titular da Conta
    @Override
    public String getNomeTitular() {
        return this.nomeTitular;
    }
    
    // Método para pegar o número da Agência
    @Override
    public String getAgencia() {
        return this.agencia;
    }
    
    
    @Override
    public String getCpfTitular() {
        return this.cpfTitular;
    }

    /**
     * Método para transferir dinheiro de uma conta poupança para outra conta
     * bancária.
     *
     * @param destino A conta bancária de destino.
     * @param valor O valor a ser transferido.
     * @throws SaldoInsuficienteException Se o saldo for insuficiente para
     * realizar a transferência.
     */
    @Override
    public void transferir(ContaBancaria destino, double valor) throws SaldoInsuficienteException {
        if (valor > getSaldo()) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar a transferência.");
        } else {
            saldo -= valor;
            destino.depositar(valor);
        }
    }
}
