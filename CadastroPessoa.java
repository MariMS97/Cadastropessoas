class CadastroPessoas {
    private Pessoa[] pessoas;
    private int qtdAtual;

    public CadastroPessoas(int tamanho) {
        pessoas = new Pessoa[tamanho];
        qtdAtual = 0;
    }

    public void cadastroPessoas(Pessoa pess) {
        if (qtdAtual < pessoas.length) {
            pessoas[qtdAtual] = pess;
            qtdAtual++;
        } else {
            System.out.println("Erro: Cadastro cheio.");
        }
    }

    public void imprimeCadastro() {
        for (int i = 0; i < qtdAtual; i++) {
            pessoas[i].imprimeDados();
        }
    }

    public Pessoa acessaPessoa(int indice) {
        try {
            return pessoas[indice];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro: Índice fora dos limites do array.");
            return null;
        }
    }
}