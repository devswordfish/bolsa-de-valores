package bolsaDeValores;

import estruturadados.StaticArray;

public class Corretora {
    private float corretagem;
    private String nome;
    private int vendas;

    public Corretora(String nome, float corretagem) {
        this.corretagem = corretagem;
        this.vendas = 0;
        this.nome = nome;
    }

    public float getCorretagem() {
        return corretagem;
    }

    public void setCorretagem(float corretagem) {
        this.corretagem = corretagem;
    }

    public int getVendas() {
        return vendas;
    }

    public void setVendas(int vendas) {
        this.vendas = vendas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
