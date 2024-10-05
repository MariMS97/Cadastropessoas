import java.util.Scanner;
public class TestaCadastro {
    public static void main(String[] args) {
        CadastroPessoa cadastro = new CadastroPessoa();
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Cadastrar pessoa");
            System.out.println("2 - Imprimir cadastro");
            System.out.println("3 - Acessar pessoa por índice");
            System.out.println("4 - Sair");
            int escolha = sc.nextInt();

            switch (escolha) {
                case 1:
                    cadastro.cadastraPessoa();
                    break;
                case 2:
                    cadastro.imprimeCadastro();
                    break;
                case 3:
                    cadastro.acessaPessoa();
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        sc.close();
    }
}

