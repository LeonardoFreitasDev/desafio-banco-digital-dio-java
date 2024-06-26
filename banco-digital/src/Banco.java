import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco {

    private String nome;
    private List<Conta> contas = new ArrayList<Conta>();

    public Banco(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public Conta buscarConta(){
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = input.nextLine();
        System.out.print("Digite o número da agência: ");
        int numeroAgencia = input.nextInt();
        System.out.print("Digite o número da conta: ");
        int numeroConta = input.nextInt();
        for(Conta conta : getContas()){
            if(conta.cliente.getNome().equals(nomeCliente) && (conta.getAgencia() == numeroAgencia) && (conta.getNumero() == numeroConta) ){
                return conta;
            }
        }
        System.out.println("Nenhuma conta foi encontrada com esse cliente");
        return null;
    }

    public void abrirContaCorrente(){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome do cliente: ");
        String nome = input.nextLine();
        System.out.println("Digite a idade do cliente: ");
        int idade = input.nextInt();
        Cliente cliente = new Cliente(nome, idade);

        if(cliente.verificaMaiorIdade()){
            contas.add(new ContaCorrente(cliente));
            System.out.printf("Parabéns %s! Conta Corrente Aberta com Sucesso!%n", cliente.getNome());
        }else{
            System.out.printf("%s, Você não tem idade suficiente para abrir uma conta.%n", cliente.getNome());
        }
    }

    public void abrirContaPoupanca(){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome do cliente: ");
        String nome = input.nextLine();
        System.out.println("Digite a idade do cliente: ");
        int idade = input.nextInt();
        Cliente cliente = new Cliente(nome, idade);

        if(cliente.verificaMaiorIdade()){
            contas.add(new ContaPoupanca(cliente));
            System.out.printf("Parabéns %s! Conta Poupança Aberta com Sucesso!%n", cliente.getNome());
        }else{
            System.out.printf("%s, você não tem idade suficiente para abrir uma conta.%n", cliente.getNome());
        }
    }

    public void exibirExtratoCliente(){
        Conta contaBuscada = buscarConta();
        if(contaBuscada != null) contaBuscada.imprimirExtrato();

    }

    public void fazerDepositoCliente(){
        Conta contaDeposito = buscarConta();
        if(contaDeposito != null){
            Scanner input = new Scanner(System.in);
            System.out.print("Digite o valor a ser depositado: ");
            double valorDeposito = input.nextDouble();
            contaDeposito.depositar(valorDeposito);
        }

    }

    public void fazerSaqueCliente(){
        Conta contaSaque = buscarConta();
        if(contaSaque != null){
            Scanner input = new Scanner(System.in);
            System.out.print("Digite o valor a ser retirado: ");
            double valorSaque = input.nextDouble();
            contaSaque.sacar(valorSaque);
        }

    }

    public void fazerTransferencia(){
        System.out.println("--- Conta de Origem ---");
        Conta contaOrigem = buscarConta();
        System.out.println("--- Conta de Destino ---");
        Conta contaDestino = buscarConta();

        if((contaOrigem != null) && (contaDestino != null)){
            Scanner input = new Scanner(System.in);
            System.out.print("Digite o valor da transferência: ");
            double valorTransferencia =  input.nextDouble();
            contaOrigem.transferir(valorTransferencia, contaDestino);
        }
    }

    public void imprimirListaContas(){
        for (Conta conta : getContas()){
            conta.imprimirInfosComuns();
        }
    }

    public void imprimirListaClientes(){
        for (Conta conta : getContas()){
            System.out.println("Cliente: " + conta.cliente.getNome());
        }
    }

    public void menuOpcoes(){
        Scanner input = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("Digite 1 para: Abrir uma conta corrente");
            System.out.println("Digite 2 para: Abrir uma conta poupança");
            System.out.println("Digite 3 para: Verificar seu extrato da conta");
            System.out.println("Digite 4 para: Fazer um deposito");
            System.out.println("Digite 5 para: Fazer um saque");
            System.out.println("Digite 6 para: Fazer uma transferecia");
            System.out.println("Digite 7 para: Listar todos os clientes");
            System.out.println("Digite 8 para: Listar todas as contas");
            System.out.println("Digite 0 para: Encerrar");

            System.out.print("Que operação deseja realizar: ");
            opcao = input.nextInt();

            switch (opcao){
                case 1:
                    abrirContaCorrente();
                    continue;
                case 2:
                    abrirContaPoupanca();
                    continue;
                case 3:
                    exibirExtratoCliente();
                    continue;
                case 4:
                    fazerDepositoCliente();
                    continue;
                case 5:
                    fazerSaqueCliente();
                    continue;
                case 6:
                    fazerTransferencia();
                    continue;
                case 7:
                    imprimirListaClientes();
                    continue;
                case 8:
                    imprimirListaContas();
                    continue;
                case 0:
                    System.out.println("Programa encerrado.");
                default:
                    System.out.println("Opção inválida!");
            }
        }while(opcao != 0);
    }
}