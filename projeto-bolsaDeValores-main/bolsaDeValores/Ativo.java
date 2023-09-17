package bolsaDeValores;

// super classe para os investimentos
public abstract class Ativo {
    private String nome;
    private String sigla;
    private float valor;
    private float dividendos;

    public Ativo(String nome, String sigla, float valor, float dividendos) {
        this.nome = nome;
        this.sigla = sigla;
        this.valor = valor;
        this.dividendos = dividendos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getDividendos() {
        return dividendos;
    }

    public void setDividendos(float dividendos) {
        this.dividendos = dividendos;
    }
}
