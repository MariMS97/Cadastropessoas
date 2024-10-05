import java.util.ArrayList;
public class PessoaService {
    private final ArrayList<Pessoa> pessoas = new ArrayList<>();
    private int qtdFuncionarios = 0;
    private boolean gerenteCadastrado = false;
    private final int LIMITE_FUNCIONARIOS = 7;

    public void cadastrarCliente(Cliente cliente) {
        pessoas.add(cliente);
    }

    public void cadastrarClienteVip(ClienteVip clienteVip) {
        pessoas.add(clienteVip);
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        if (qtdFuncionarios >= LIMITE_FUNCIONARIOS) {
            try {
                throw new QuantidadeExcedidaException("Quantidade de funcionários excedida (máximo de 7).");
            } catch (QuantidadeExcedidaException e) {
                throw new RuntimeException(e);
            }
        }
        pessoas.add(funcionario);
        qtdFuncionarios++;
    }

    public void cadastrarGerente(Gerente gerente) throws QuantidadeExcedidaException {
        if (gerenteCadastrado) {
            throw new QuantidadeExcedidaException("Já existe um gerente cadastrado.");
        }
        pessoas.add(gerente);
        gerenteCadastrado = true;
    }

    public void imprimeCadastro() {
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
        } else {
            for (Pessoa pessoa : pessoas) {
                pessoa.imprimeDados();
            }
        }
    }

    public Pessoa acessaPessoa(int indice) throws IndexOutOfBoundsException {
        if (indice < 0 || indice >= pessoas.size()) {
            throw new IndexOutOfBoundsException("Índice fora dos limites do array.");
        }
        return pessoas.get(indice);
    }
}


