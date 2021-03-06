package vetorgenerico;

import java.util.Iterator;

public class Iterador<T> implements Iterator {

    T[] vetor;
    int posicao = 0;

    public Iterador(T[] itens) {
        this.vetor = itens;
    }

    public boolean hasNext() {
        if (posicao < 0 || posicao >= vetor.length) {
            return false;
        } else {
            return true;
        }
    }

    public Object next() {
        Object item = vetor[posicao];
        posicao++;
        return item;
    }

}
