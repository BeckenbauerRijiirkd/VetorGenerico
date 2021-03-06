package vetorgenerico;

import java.util.Iterator;

public class VetorGenerico {

    public static void main(String[] args) {
        Vetor vetor;

        vetor = new Vetor(2);

        vetor.AdicionarIt("Teste");

        vetor.AdicionarIt(12);

        vetor.Imprimir();

        vetor.AdicionarPrimeiro("TESTE DO PRIMEIRO");

        System.out.println(vetor.Tamanho() + " Elementos preenchidos");

        System.out.println("-----------------------------");

        vetor.Imprimir();

        System.out.println("=---------------------------------");

        vetor.AdicionarPrimeiro("SEGUNDO TESTE");

        vetor.Imprimir();
        System.out.println("=======================");
        vetor.AdicionarFim("TESTE DO FIM");
        vetor.Imprimir();

        System.out.println("----------------------");
        vetor.AdicionarFim("Segudno teste do FIM");

        vetor.Imprimir();

        System.out.println("===================");
        vetor.AdicionarFim("TERCEIRO TESTE DO FIM");
        vetor.Imprimir();
        System.out.println("++++++++++++++++++");

        vetor.ExisteDado(0);
        System.out.println("'''''''''''''''''''''''");
        vetor.ExisteDado(7);

        vetor.Vazio();
        System.out.println("=====================");
        vetor.RemoveFim();
        vetor.RemoveFim();

        System.out.println("++++++++++++++++++++++++++");
        System.out.println("DEPOIS DA REMOÇÃO");
        vetor.Imprimir();

        System.out.println("___-----------------_______");

        vetor.Recupera(4);

    }
}
