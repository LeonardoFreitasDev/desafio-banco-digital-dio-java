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

    public void abrirContaCorrente(Cliente cliente){
        if(cliente.verificaMaiorIdade()){
            contas.add(new ContaCorrente(cliente));
            System.out.printf("Parabéns %s! Conta Corrente Aberta com Sucesso!%n", cliente.getNome());
        }else{
            System.out.printf("%s, Você não tem idade suficiente para abrir uma conta.", cliente.getNome());
        }
    }

    public void abrirContaPoupanca(Cliente cliente){
        if(cliente.verificaMaiorIdade()){
            contas.add(new ContaPoupanca(cliente));
            System.out.printf("Parabéns %s! Conta Poupança Aberta com Sucesso!%n", cliente.getNome());
        }else{
            System.out.printf("%s, você não tem idade suficiente para abrir uma conta.", cliente.getNome());
        }
    }

    public void imprimirListaContas(){
        for (Conta conta : getContas()){
            conta.imprimirInfosComuns();
        }
    }
}