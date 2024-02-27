/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vainubank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author sherlocod3 (Alexandre Cavalari)
 */
/**
 * Classe que representa um banco.
 *
 * Características principais: - Gerencia a criação e operações em contas
 * bancárias. - Exibe um menu para interação com o usuário, permitindo a criação
 * de contas, realização de saques, depósitos e transferências.
 */
// Obs.: Não há como fazer "Clean Code" nessa fase, risos. Preciso registrar a lógica e as funções para futuras consultas.
public class Banco {

    private List<ContaBancaria> contas;

    /**
     * Construtor da classe Banco. Inicializa a lista de contas bancárias.
     */
    public Banco() {
        contas = new ArrayList<>();
    }

    /**
     * Método para adicionar uma conta ao banco.
     *
     * @param conta A conta a ser adicionada.
     */
    public void adicionarConta(ContaBancaria conta) {
        contas.add(conta);
    }

    /**
     * Método para exibir o menu de opções para o usuário.
     */
    // Método para exibir o menu de opções
    public void exibirMenu() {
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║                Menu de Opções                ║");
        System.out.println("╟──────────────────────────────────────────────╢");
        System.out.println("║ 1. Criar Conta Corrente                      ║");
        System.out.println("╟──────────────────────────────────────────────╢");
        System.out.println("║ 2. Criar Conta Poupança                      ║");
        System.out.println("╟──────────────────────────────────────────────╢");
        System.out.println("║ 3. Realizar Saque                            ║");
        System.out.println("╟──────────────────────────────────────────────╢");
        System.out.println("║ 4. Realizar Depósito                         ║");
        System.out.println("╟──────────────────────────────────────────────╢");
        System.out.println("║ 5. Realizar Transferência                    ║");
        System.out.println("╟──────────────────────────────────────────────╢");
        System.out.println("║ 6. Consultar Saldo                           ║");
        System.out.println("╟──────────────────────────────────────────────╢");
        System.out.println("║ 7. Listar Contas                             ║");
        System.out.println("╟──────────────────────────────────────────────╢");
        System.out.println("║ 8. Sair                                      ║");
        System.out.println("╚══════════════════════════════════════════════╝");
        System.out.print("Escolha uma opção: ");
    }

    // Método para criar uma conta corrente
    public void criarContaCorrente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Criando Conta Corrente...");
        System.out.print("Número da Conta: ");
        String numero = scanner.nextLine();
        System.out.print("Agência: ");
        String agencia = scanner.nextLine();
        System.out.print("Nome do Titular: ");
        String nomeTitular = scanner.nextLine();
        System.out.print("CPF do Titular: ");
        String cpfTitular = scanner.nextLine();
        System.out.print("Limite de Crédito: ");
        double limiteCredito = scanner.nextDouble();

        ContaCorrente contaCorrente = new ContaCorrente(numero, agencia, nomeTitular, cpfTitular, limiteCredito);
        adicionarConta(contaCorrente);
        System.out.println("Conta Corrente criada com sucesso!");
    }

    // Método para criar uma conta poupança
    public void criarContaPoupanca() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Criando Conta Poupança...");
        System.out.print("Número da Conta: ");
        String numero = scanner.nextLine();
        System.out.print("Agência: ");
        String agencia = scanner.nextLine();
        System.out.print("Nome do Titular: ");
        String nomeTitular = scanner.nextLine();
        System.out.print("CPF do Titular: ");
        String cpfTitular = scanner.nextLine();
        System.out.print("Dia de Aniversário: ");
        int diaAniversario = scanner.nextInt();

        ContaPoupanca contaPoupanca = new ContaPoupanca(numero, agencia, nomeTitular, cpfTitular, diaAniversario);
        adicionarConta(contaPoupanca);
        System.out.println("Conta Poupança criada com sucesso!");
    }

    // Método para excluir uma conta com base no número da conta
    public void excluirConta(String numeroConta) {
        for (Iterator<ContaBancaria> iterator = contas.iterator(); iterator.hasNext();) {
            ContaBancaria conta = iterator.next();
            if (conta.getNumero().equals(numeroConta)) {
                iterator.remove(); // Remove a conta da lista
                System.out.println("Conta excluída com sucesso!");
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }

// Método para editar uma conta com base no número da conta
    public void editarConta(String numeroConta) {
        Scanner scanner = new Scanner(System.in);

        for (ContaBancaria conta : contas) {
            if (conta.getNumero().equals(numeroConta)) {
                System.out.println("Conta encontrada. Informações atuais:");

                // Exibe as informações atuais da conta
                System.out.println("Número da Conta: " + conta.getNumero());
                System.out.println("Agência: " + conta.getAgencia());
                System.out.println("Nome do Titular: " + conta.getNomeTitular());
                System.out.println("CPF do Titular: " + conta.getCpfTitular());

                // Se for uma conta corrente, exibe o limite de crédito atual
                if (conta instanceof ContaCorrente) {
                    ContaCorrente cc = (ContaCorrente) conta;
                    System.out.println("Limite de Crédito: " + cc.getLimiteCredito());
                }

                // Se for uma conta poupança, exibe o dia de aniversário atual
                if (conta instanceof ContaPoupanca) {
                    ContaPoupanca cp = (ContaPoupanca) conta;
                    System.out.println("Dia de Aniversário: " + cp.getDiaAniversario());
                }

                System.out.println("Informe as novas informações:");

                // Atualiza as informações da conta
                System.out.print("Novo Número da Conta: ");
                String novoNumero = scanner.nextLine();
                conta.setNumero(novoNumero);

                System.out.print("Nova Agência: ");
                String novaAgencia = scanner.nextLine();
                conta.setAgencia(novaAgencia);

                System.out.print("Novo Nome do Titular: ");
                String novoNomeTitular = scanner.nextLine();
                conta.setNomeTitular(novoNomeTitular);

                System.out.print("Novo CPF do Titular: ");
                String novoCpfTitular = scanner.nextLine();
                conta.setCpfTitular(novoCpfTitular);

                // Se for uma conta corrente, solicita o novo limite de crédito
                if (conta instanceof ContaCorrente) {
                    System.out.print("Novo Limite de Crédito: ");
                    double novoLimiteCredito = scanner.nextDouble();
                    ((ContaCorrente) conta).setLimiteCredito(novoLimiteCredito);
                }

                // Se for uma conta poupança, solicita o novo dia de aniversário
                if (conta instanceof ContaPoupanca) {
                    System.out.print("Novo Dia de Aniversário: ");
                    int novoDiaAniversario = scanner.nextInt();
                    ((ContaPoupanca) conta).setDiaAniversario(novoDiaAniversario);
                }

                System.out.println("Conta atualizada com sucesso!");
                return;
            }
        }

        System.out.println("Conta não encontrada para edição.");
    }

    // Método para realizar saque
    public void realizarSaque() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Realizando Saque...");
        System.out.print("Número da Conta: ");
        String numero = scanner.nextLine();
        System.out.print("Valor do Saque: ");
        double valor = scanner.nextDouble();

        // Itera sobre todas as contas no banco
        for (ContaBancaria conta : contas) {
            // Verifica se a conta atual possui o número fornecido pelo usuário
            if (conta.getNumero().equals(numero)) {
                try {
                    // Tenta realizar o saque na conta encontrada
                    conta.sacar(valor);
                    // Se o saque for bem-sucedido, informa ao usuário e exibe o saldo remanescente
                    System.out.println("Saque realizado com sucesso!");
                    System.out.printf("Saldo remanescente: %.2f%n", conta.getSaldo());
                } catch (SaldoInsuficienteException e) {
                    // Se o saldo for insuficiente, exibe uma mensagem de erro
                    System.out.println("Erro ao realizar saque: " + e.getMessage());
                }
                return; // Encerra o método após o saque ser concluído
            }
        }
        // Se nenhum número de conta correspondente for encontrado, exibe uma mensagem de conta não encontrada
        System.out.println("Conta não encontrada.");
    }

    // Método para realizar depósito
    public void realizarDeposito() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Realizando Depósito...");
        System.out.print("Número da Conta: ");
        String numero = scanner.nextLine();
        System.out.print("Valor do Depósito: ");
        double valor = scanner.nextDouble();

        // Itera sobre todas as contas no banco
        for (ContaBancaria conta : contas) {
            // Verifica se a conta atual possui o número fornecido pelo usuário
            if (conta.getNumero().equals(numero)) {
                // Realiza o depósito na conta encontrada
                conta.depositar(valor);
                // Informa ao usuário que o depósito foi realizado com sucesso
                System.out.println("Depósito realizado com sucesso!");
                // Exibe o saldo remanescente na conta após o depósito
                System.out.printf("Saldo remanescente: %.2f%n", conta.getSaldo());
                return; // Encerra o método após o depósito ser concluído
            }
        }
        // Se nenhum número de conta correspondente for encontrado, exibe uma mensagem de conta não encontrada
        System.out.println("Conta não encontrada.");
    }

    public void consultarSaldo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número da conta que deseja consultar: ");
        String numeroConta = scanner.nextLine();

        for (ContaBancaria conta : contas) {
            if (conta.getNumero().equals(numeroConta)) {
                // Exibe o saldo da conta encontrada
                System.out.printf("Saldo da conta: %.2f%n", conta.getSaldo());
                return; // Encerra o método após exibir o saldo
            }
        }

        System.out.println("Conta não encontrada.");
    }

    // Método para listar todas as contas cadastradas
    public void listarContas() {
        System.out.println("Lista de Contas Cadastradas:");
        Iterator<ContaBancaria> iterator = contas.iterator();
        while (iterator.hasNext()) {
            ContaBancaria conta = iterator.next();
            System.out.println("Número da Conta: " + conta.getNumero());
            System.out.println("Nome do Titular: " + conta.getNomeTitular());
            System.out.println("=========================================");
        }
        // Prompt para retornar ao menu
        System.out.println("Pressione Enter para voltar ao menu...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // Aguarda uma entrada do usuário
    }

    // Método para realizar transferência
    public void realizarTransferencia() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Realizando Transferência...");
        System.out.print("Número da Conta de Origem: ");
        String numeroOrigem = scanner.nextLine();
        System.out.print("Número da Conta de Destino: ");
        String numeroDestino = scanner.nextLine();
        System.out.print("Valor da Transferência: ");
        double valor = scanner.nextDouble();

        ContaBancaria origem = null;
        ContaBancaria destino = null;

        // Itera sobre todas as contas no banco
        for (ContaBancaria conta : contas) {
            // Verifica se a conta atual possui o número de origem fornecido pelo usuário
            if (conta.getNumero().equals(numeroOrigem)) {
                origem = conta; // Armazena a conta de origem encontrada
            }
            // Verifica se a conta atual possui o número de destino fornecido pelo usuário
            if (conta.getNumero().equals(numeroDestino)) {
                destino = conta; // Armazena a conta de destino encontrada
            }
        }
        // Verifica se ambas as contas foram encontradas
        if (origem != null && destino != null) {
            try {
                // Tenta realizar a transferência entre as contas de origem e destino
                origem.transferir(destino, valor);
                // Se a transferência for bem-sucedida, informa ao usuário e exibe o saldo remanescente na conta de origem
                System.out.println("Transferência realizada com sucesso!");
                System.out.printf("Saldo remanescente na conta de origem: %.2f%n", origem.getSaldo());
            } catch (SaldoInsuficienteException e) {
                // Se o saldo for insuficiente na conta de origem, exibe uma mensagem de erro
                System.out.println("Erro ao realizar transferência: " + e.getMessage());
            }
        } else {
            // Se alguma das contas não for encontrada, exibe uma mensagem de conta não encontrada
            System.out.println("Conta de origem ou conta de destino não encontrada.");
        }
    }

    // Método para iniciar o programa
    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 8) {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    criarContaCorrente();
                    break;
                case 2:
                    criarContaPoupanca();
                    break;
                case 3:
                    realizarSaque();
                    break;
                case 4:
                    realizarDeposito();
                    break;
                case 5:
                    realizarTransferencia();
                    break;
                case 6:
                    consultarSaldo();
                    break;
                case 7:
                    listarContas();
                    break;
                case 8:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Banco banco = new Banco();
        banco.iniciar();
    }
}

// Anotações:
// O operador instanceof é usado para verificar se um objeto é uma instância de uma determinada classe
// ou de uma classe que herda dessa classe.
// Sintaxe:
// objeto instanceof Tipo
// onde:
// - objeto é uma referência a um objeto.
// - Tipo é o tipo de classe que estamos verificando.
// Exemplo:
// Se temos um objeto 'obj' e queremos verificar se ele é uma instância da classe 'MinhaClasse',
// podemos fazer isso usando o operador instanceof da seguinte forma:
// if (obj instanceof MinhaClasse) {
//     // Se o objeto 'obj' for uma instância da classe 'MinhaClasse' ou de uma classe que herda de 'MinhaClasse',
//     // então este bloco de código será executado.
// }
// O operador instanceof retorna true se o objeto for uma instância do tipo especificado
// ou de uma subclasse desse tipo. Caso contrário, retorna false.
// É útil para verificar o tipo de um objeto antes de fazer cast ou chamar métodos específicos
// disponíveis apenas para aquele tipo de objeto, evitando assim possíveis erros em tempo de execução.
// Por exemplo, antes de fazer cast de um objeto para um tipo mais específico, podemos verificar
// se é seguro fazer isso usando o operador instanceof para garantir que não ocorram exceções de cast inválido.
