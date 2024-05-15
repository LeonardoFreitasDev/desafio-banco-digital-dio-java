public class Cliente extends Pessoa{

    public Cliente(String nome, int idade) {
        super(nome, idade);
    }

    public boolean verificaMaiorIdade(){
        return getIdade() >= 18;
    }
}