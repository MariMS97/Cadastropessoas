
class Cliente extends Pessoa {
    int codigo;
    public Cliente(String nome, Data nascimento, int codigo) {
        super(nome, nascimento);
        this.codigo = codigo;
    }
    //Imprime dados
    @Override
    public void imprimeDados(){
        System.out.println("Nome: " + nome);
        System.out.println("Nascimento: " + nascimento);
        System.out.println("Código: " + codigo);
    }
}
