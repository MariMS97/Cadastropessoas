public class ClienteVip extends Cliente{
    float percentualDesconto;

    public ClienteVip(String nome, Data nascimento, int codigo, float percentualDesconto) {
        super(nome, nascimento, codigo);
        this.percentualDesconto = percentualDesconto;
    }

    @Override
    public void imprimeDados(){
        System.out.println("Cliente VIP: " + nome + ", Código: " + codigo + ", Nascimento: " + nascimento + ", Desconto: " + percentualDesconto);
    }
}
