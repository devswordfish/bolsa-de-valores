package bolsaDeValores;

import estruturadados.StaticArray;

public class Bolsa {
    private String nome;
    private StaticArray<Ativo> ativos;
    private StaticArray<Corretora> corretoras;

    public Bolsa(String nome) {
        this.nome = nome;
        this.ativos = new StaticArray<>(0);
        this.corretoras = new StaticArray<>(10);
    }

    public void addCorretora(Corretora corretora) {
        this.corretoras.add(corretora);
    }

    public void melhoresCorretoras() {
        String nomescorretoras[] = {"-","-","-"};
        int vendascorretoras[] = {0,0,0};

        corretoras.forEach(corretora -> {
            if (corretora.getVendas() > vendascorretoras[0]) {

                vendascorretoras[2] = vendascorretoras[1];
                nomescorretoras[2] = nomescorretoras[1];

                vendascorretoras[1] = vendascorretoras[0];
                nomescorretoras[1] = nomescorretoras[0];

                vendascorretoras[0] = corretora.getVendas();
                nomescorretoras[0] = corretora.getNome();
            }

            else if (corretora.getVendas() < vendascorretoras[0] && corretora.getVendas() > vendascorretoras[1]) {
                vendascorretoras[2] = vendascorretoras[1];
                nomescorretoras[2] = nomescorretoras[1];

                vendascorretoras[1] = corretora.getVendas();
                nomescorretoras[1] = corretora.getNome();
            }

            else if (corretora.getVendas() < vendascorretoras[1] && corretora.getVendas() > vendascorretoras[2]) {
                vendascorretoras[2] = corretora.getVendas();
                nomescorretoras[2] = corretora.getNome();
            }
        });

        for (int i = 1; i < vendascorretoras.length + 1; i++) {
            System.out.println(i + "º " + nomescorretoras[i - 1] + " " + vendascorretoras[i - 1]);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public StaticArray<Ativo> getAtivos() {
        return ativos;
    }

    public void setAtivos(StaticArray<Ativo> ativos) {
        this.ativos = ativos;
    }
}
