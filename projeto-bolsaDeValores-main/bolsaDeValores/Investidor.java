package bolsaDeValores;

import estruturadados.StaticArray;

public class Investidor {
    private String nome;
    private StaticArray<Ativo> ativos;
    private float dinheiro;

    private StaticArray<String> historico;

    public Investidor(String nome, float dinheiro) {
        this.nome = nome;
        this.dinheiro = dinheiro;
        this.ativos = new StaticArray<>(10);
        this.historico = new StaticArray<>(10);
    }

    private void resizeAtivos(int newCapacity) {
        StaticArray<Ativo> temp = new StaticArray<>(newCapacity);
        ativos.forEach(ativo -> temp.add(ativo));
        ativos = temp;
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
        this.ativos = Investidor.this.ativos;
    }

    public float getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(float dinheiro) {
        this.dinheiro = dinheiro;
    }

    public void comprar (Corretora corretora, Ativo ativo, int quantidade) {
        if (quantidade < 0)
            throw new RuntimeException("Quantidade nao pode ser negativa");

        // verfica se o investidor tem dinheiro suficente para comprar algum ativo
        if (dinheiro < (ativo.getValor() * (1 + corretora.getCorretagem())) * quantidade)
            throw new RuntimeException("Nao tem dinheiro suficiente");

        this.historico.add(String.format("Comprou o ativo %s por R$%.2f", ativo.getNome(), ativo.getValor()));

        // compra do ativo
        dinheiro -= (ativo.getValor() * (1 + corretora.getCorretagem())) * quantidade;

        if (ativos.getSize() + quantidade > ativos.getCapacity())
            this.resizeAtivos(ativos.getCapacity() + quantidade + 10);

        for (int i = 0; i < quantidade; i++) {
            ativos.add(ativo);
        }

        // aumenta o valor de vendas da corretora
        corretora.setVendas(corretora.getVendas() + quantidade);
    }

    public void vender (Ativo ativo, int quantidade) {
        if (quantidade < 0)
            throw new RuntimeException("Quantidade nao pode ser negativa");

        // vefifica se o investidor consegue vender os ativos
        if (ativos.filter(inv -> inv.equals(ativo)).getSize() < quantidade)
            throw new RuntimeException("erorr");

        float valor = (ativo.getValor() * quantidade) * (1 + ativo.getDividendos());

        this.historico.add(String.format("Vendeu o ativo %s por R$%.2f", ativo.getNome(), valor));

        // venda do ativo
        dinheiro += valor;
    }

    public void mostrarHistorico() {
        this.historico.forEach(hist -> System.out.println(hist));
    }

    public void showCarteira(){
        for(int i = 0; i < ativos.getSize(); i++){
            System.out.println(ativos.get(i).getNome());

            if (i < ativos.getSize() - 1) System.out.print(", ");
        }
    }
}
