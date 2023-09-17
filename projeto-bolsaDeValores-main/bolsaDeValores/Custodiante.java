package bolsaDeValores;

import estruturadados.StaticArray;

public class Custodiante {

    private String nome;
    private StaticArray<Carteira> carteiras;

    public Custodiante(String nome) {
        this.nome = nome;
        this.carteiras = carteiras;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public StaticArray<Carteira> getCarteiras() {
        return carteiras;
    }

    public void setCarteiras(StaticArray<Carteira> carteiras) {
        this.carteiras = carteiras;
    }
}
