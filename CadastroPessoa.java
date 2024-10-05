import java.util.Scanner;

public class CadastroPessoa {
    private final PessoaService pessoaService = new PessoaService();
    private final Scanner scanner = new Scanner(System.in);

    public void cadastraPessoa() {
        int opcao;
        while (true) {
            try {
                System.out.println("Escolha o tipo de pessoa para cadastrar (1 - Cliente, 2 - Cliente VIP, 3 - Funcionário, 4 - Gerente): ");
                opcao = scanner.nextInt();
                if (opcao < 1 || opcao > 4) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (Exception e) {
                System.out.println("Opção inválida. Por favor, digite uma opção válida.");
                scanner.nextLine();
            }
        }

        scanner.nextLine();

        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o dia de nascimento: ");
        int dia = scanner.nextInt();
        System.out.print("Digite o mês de nascimento: ");
        int mes = scanner.nextInt();
        System.out.print("Digite o ano de nascimento: ");
        int ano = scanner.nextInt();
        Data nascimento = new Data(dia, mes, ano);

        try {
            switch (opcao) {
                case 1:
                    System.out.print("Digite o código do cliente: ");
                    int codigo = scanner.nextInt();
                    Cliente cliente = new Cliente(nome, nascimento, codigo);
                    pessoaService.cadastrarCliente(cliente);
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.print("Digite o código do cliente VIP: ");
                    int codigoVip = scanner.nextInt();
                    System.out.print("Digite o percentual de desconto: ");
                    float desconto = scanner.nextFloat();
                    ClienteVip clienteVip = new ClienteVip(nome, nascimento, codigoVip, desconto);
                    pessoaService.cadastrarClienteVip(clienteVip);
                    System.out.println("Cliente VIP cadastrado com sucesso!");
                    break;
                case 3:
                    System.out.print("Digite o salário do funcionário: ");
                    float salarioFuncionario = scanner.nextFloat();
                    Funcionario funcionario = new Funcionario(nome, nascimento, salarioFuncionario);
                    pessoaService.cadastrarFuncionario(funcionario);
                    System.out.println("Funcionário cadastrado com sucesso!");
                    break;
                case 4:
                    System.out.print("Digite o salário do gerente: ");
                    float salarioGerente = scanner.nextFloat();
                    scanner.nextLine();
                    System.out.print("Digite a área do gerente: ");
                    String area = scanner.nextLine();
                    Gerente gerente = new Gerente(nome, nascimento, salarioGerente, area);
                    pessoaService.cadastrarGerente(gerente);
                    System.out.println("Gerente cadastrado com sucesso!");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } catch (QuantidadeExcedidaException e) {
            System.out.println(e.getMessage());
        }
    }

    public void imprimeCadastro() {
        pessoaService.imprimeCadastro();
    }

    public void acessaPessoa() {
        try {
            System.out.print("Digite o índice da pessoa que deseja acessar: ");
            int indice = scanner.nextInt();
            Pessoa p = pessoaService.acessaPessoa(indice);
            p.imprimeDados();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
