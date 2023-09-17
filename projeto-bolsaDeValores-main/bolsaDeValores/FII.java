package bolsaDeValores;

// FII sao investimentos que devem ter dividendos
public class FII extends Ativo {

    public FII(String nome, String sigla, float valor, float dividendos) {
        super(nome, sigla, valor, dividendos);
    }
}
