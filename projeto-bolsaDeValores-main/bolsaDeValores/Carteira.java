package bolsaDeValores;

import estruturadados.StaticArray;

public class Carteira {

    private StaticArray<Ativo> ativos;

    public Carteira() {
        this.ativos = new StaticArray<>(0);
    }

    public StaticArray<Ativo> getAtivos() {
        return ativos;
    }

    public void setAtivos(StaticArray<Ativo> ativos) {
        this.ativos = ativos;
    }
}
