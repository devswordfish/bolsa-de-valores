package bolsaDeValores;

// acoes sao investimentos que podem ou nao ter dividendos
public class Acao extends Ativo {
    public Acao(String nome, String sigla, float valor, float dividendos) {
        super(nome, sigla, valor, dividendos);
    }

    public Acao(String nome, String sigla, float valor) {
        super(nome, sigla, valor, 0);
    }
}
