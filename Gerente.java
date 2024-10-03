
class Gerente extends Funcionario {
    String area;

    public Gerente(String nome, Data nascimento, float salario, String area) {
        super(nome, nascimento, salario);
        this.area = area;
    }

    public float calculaImposto() {
        return salario * 0.03f;
    }
    @Override
    public void imprimeDados(){
        System.out.println("Nome: " + nome);
        System.out.println("Nascimento: " + nascimento);
        System.out.println("Salário: " + salario);
        System.out.println("Área: " + area);
    }
}
