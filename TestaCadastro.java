import java.util.Scanner;

public class TestaCadastro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CadastroPessoas cadastro = new CadastroPessoas(3);

        // Cadastro de pessoas
        for (int i = 0; i < 3; i++) {
            System.out.println("Digite o tipo de pessoa (1-Cliente, 2-Funcionário, 3-Gerente): ");
            int tipo = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            System.out.println("Digite o nome: ");
            String nome = scanner.nextLine();

            System.out.println("Digite a data de nascimento (dia, mês, ano): ");
            int dia = scanner.nextInt();
            int mes = scanner.nextInt();
            int ano = scanner.nextInt();
            Data nascimento = new Data(dia, mes, ano);

            switch (tipo) {
                case 1:
                    System.out.println("Digite o código do cliente: ");
                    int codigo = scanner.nextInt();
                    cadastro.cadastroPessoas(new Cliente(nome, nascimento, codigo));
                    break;
                case 2:
                    System.out.println("Digite o salário do funcionário: ");
                    float salarioFuncionario = scanner.nextFloat();
                    cadastro.cadastroPessoas(new Funcionario(nome, nascimento, salarioFuncionario));
                    break;
                case 3:
                    System.out.println("Digite o salário do gerente: ");
                    float salarioGerente = scanner.nextFloat();
                    scanner.nextLine(); // Consumir a nova linha
                    System.out.println("Digite a área do gerente: ");
                    String area = scanner.nextLine();
                    cadastro.cadastroPessoas(new Gerente(nome, nascimento, salarioGerente, area));
                    break;
                default:
                    System.out.println("Tipo inválido.");
                    i--; // Repetir a iteração para entrada válida
                    break;
            }
        }

        // Acessar pessoa pelo índice
        System.out.println("Digite o índice da pessoa que deseja acessar: ");
        int indice = scanner.nextInt();
        Pessoa pessoa = cadastro.acessaPessoa(indice);
        if (pessoa != null) {
            pessoa.imprimeDados();
        }

        // Imprimir todo o cadastro
        cadastro.imprimeCadastro();

        scanner.close();
    }
}
