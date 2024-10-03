
class Funcionario extends Pessoa {
    float salario;
    public Funcionario(String nome, Data nascimento, float salario) {
        super(nome, nascimento);
        this.salario = salario;
    }

    public float calculaImposto(){
        return salario * 0.05f;
    }

    @Override
    public void imprimeDados(){
        System.out.println("Nome: " + nome);
        System.out.println("Nascimento: " + nascimento);
        System.out.println("Salário: " + salario);
    }
}
