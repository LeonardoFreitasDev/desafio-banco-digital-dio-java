//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco("Banco do Brasil");

        Cliente leonardo = new Cliente("Leonardo", 28);
        Cliente ingrid = new Cliente("Ingrid", 25);
        Cliente joao = new Cliente("João", 15);

        banco.abrirContaCorrente(leonardo);
        banco.abrirContaPoupanca(ingrid);
        banco.abrirContaCorrente(joao);

        banco.imprimirListaContas();

    }
}