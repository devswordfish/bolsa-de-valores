import bolsaDeValores.Acao;
import bolsaDeValores.Ativo;
import bolsaDeValores.Bolsa;
import bolsaDeValores.Corretora;
import bolsaDeValores.Investidor;

public class Main {
    public static void main(String[] args) {
        // Corretora corretora1 = new Corretora("AAA", 0.1f);
        // Corretora corretora2 = new Corretora("BBB", 0.1f);
        // Corretora corretora3 = new Corretora("CCC", 0.1f);

        // Bolsa bolsa = new Bolsa("IVX");

        // bolsa.addCorretora(corretora1);
        // bolsa.addCorretora(corretora2);
        // bolsa.addCorretora(corretora3);

        // Investidor Joel = new Investidor("Joel",  100);

        // Acao acao = new Acao("Salgabitos", "S132", 1);

        // Joel.comprar(corretora1, acao, 1);
        // Joel.comprar(corretora2, acao, 2);
        // Joel.comprar(corretora3, acao, 3);
        // // System.out.println(Joel.getDinheiro());

        // Joel.vender(acao, 1);
        // // System.out.println(Joel.getDinheiro());

        // Joel.mostrarHistorico();
        // bolsa.melhoresCorretoras();

        Corretora corretora = new Corretora("A", 0.1f);

        Investidor Joel = new Investidor("Joel",  100);

        Acao acao = new Acao("Salgabitos", "S132", 1);

        Ativo ativo = new Acao("Cardbox", "KSSK", 100, 4);

        Joel.comprar(corretora, acao, 1);
        System.out.println(Joel.getDinheiro());

        Joel.vender(acao, 1);
        System.out.println(Joel.getDinheiro());

        // Joel.ativos(ativo, 1);
        Joel.showCarteira();
    }
}
