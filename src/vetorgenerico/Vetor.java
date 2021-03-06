package vetorgenerico;

import java.util.Iterator;

public class Vetor<T> {

    //Vetor Genérico	
    private T[] vetor;

    //Variável que controla quantidade de elementos do vetor
    private int qntElementos = 0;
    public int elementos = 0;

    //Construtor específico da Classe Vetor
    public Vetor() {

    }

    public Vetor(int tam) {
        //Criando um novo vetor genérico
        vetor = (T[]) new Object[tam];

        this.qntElementos = tam;
    }

    //Método que adiciona no vetor
    public void Adicionar(T elemento, int posicao) {
        if (Tamanho() == vetor.length) {
            Redimensionar();
        }

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[posicao] == null) {
                vetor[posicao] = elemento;
                qntElementos++;
                break;
            }
        }
    }

    //Método que adiciona no vetor usando o recurso de Iterador
    public void AdicionarIt(T elemento) {

        if (Tamanho() == vetor.length) {
            Redimensionar();
        }

        //Passamos o vetor como parâmetro para o iterador
        Iterador it = new Iterador(vetor);

        int i = 0;
        while (it.hasNext()) { //percorrendo o vetor usando iterador

            if (it.next() == null) {
                vetor[i] = elemento;
                qntElementos++;
                break;
            }
            i++;
        }
    }

    //Método que adiciona no inicio do vetor
    public void AdicionarPrimeiro(T elemento) {
        if (Tamanho() == vetor.length) {
            Redimensionar();
        }
        int tamanho = Tamanho();

        T[] vetorAux = (T[]) new Object[(tamanho + 1)];

        vetorAux[0] = elemento;

        Iterador it = new Iterador(vetorAux);
        int i = 0;
        int j = 1;
        while (it.hasNext()) {
            if (it.next() == null) {
                vetorAux[j] = vetor[(i)];

                i++;
                j++;
            }

        }
        vetor = vetorAux;
    }

    //Método que adiciona no fim do vetor
    public void AdicionarFim(T elemento) {
        if (Tamanho() == vetor.length) {
            Redimensionar();
        }
        int tamanho = Tamanho();

        T[] vetorAux = (T[]) new Object[(tamanho + 1)];

        vetorAux[(tamanho)] = elemento;

        int i = 0;
        Iterador it = new Iterador(vetorAux);
        while (it.hasNext()) {
            if (it.next() == null) {
                vetorAux[i] = vetor[i];
                i++;
            }

        }
        vetor = vetorAux;

    }

    //Método que recupera um elemento, retornando um elemento T
    public T[] Recupera(int posicao) {
        Atualizar();
        T[] vetorAux = (T[]) new Object[1];
        try {
            ExisteDado(posicao);

            vetorAux[0] = vetor[posicao];
            System.out.println("ELEMENTO: " + vetorAux[0]);
            return vetorAux;
        } catch (Exception e) {
            return vetorAux;
        }

    }

    //Método que remove um elemento passando como parametro sua posição
    public void Remove(int posicao) {

        if (ExisteDado(posicao) == true) {
            vetor[posicao] = null;

        }

        Atualizar();

    }

    //Método que remove o elemento do inicio do vetor
    public void RemoveInicio() {

        vetor[0] = null;
        Atualizar();

    }

    //Método que remove o elemento do fim do vetor
    public void RemoveFim() {

        Atualizar();
        vetor[(Tamanho() - 1)] = null;
    }

    //Método que verifica se a um elemento na posição passada
    public boolean ExisteDado(int pos) {
        boolean aux = true;
        try {
            if (vetor[pos] != null) {
                aux = true;
                System.out.println("EXISTE ELEMENTO NA POSIÇÃO: " + pos + " DA LISTA");
            }
        } catch (Exception e) {
            aux = false;
            System.out.println("NÃO EXISTE ELEMENTO NA POSIÇÃO: " + pos + " DA LISTA");
        }
        return aux;
    }

    //Método que verifica se o vetor esta vazio
    public boolean Vazio() {
        Iterador it = new Iterador(vetor);
        boolean aux = true;
        while (it.hasNext()) {
            if (it.next() != null) {
                aux = false;
            }
        }
        if (aux == false) {
            System.out.println("A LISTA NÃO ESTA VAZIA");
        } else {
            System.out.println("A LISTA ESTA VAZIA");
        }
        return aux;
    }

    //Método que limpa todo o vetor
    public void Limpa() {
        T[] vetoraux = (T[]) new Object[(0)];
        vetor = vetoraux;
    }

    //Método que redimenciona o vetor caso chego no seu limite
    public void Redimensionar() {
        T[] novoVetor = (T[]) new Object[vetor.length * 2];
        for (int i = 0; i < vetor.length; i++) {
            novoVetor[i] = vetor[i];
        }
        vetor = novoVetor;
    }

    //Método que verifica o tamanho real do vetor
    public int Tamanho() {
        this.elementos = 0;
        for (int i = 0; i < vetor.length; i++) {

            if (vetor[i] != null) {
                this.elementos = this.elementos + 1;
            }
        }
        return this.elementos;
    }

    //Método que Imprimi o vetor
    public void Imprimir() {

        for (int i = 0; i < Tamanho(); i++) {
            System.out.println(vetor[i] + " Posição : " + i + " do vetor");
        }

    }

    //Método que Atualiza o vetor eliminando os valores null
    public void Atualizar() {
        int tamanho = Tamanho();

        T[] vetorAux = (T[]) new Object[tamanho];

        Iterador it = new Iterador(vetor);
        int i = 0;
        int j = 0;
        while (it.hasNext()) {
            if (it.next() != null) {
                vetorAux[i] = vetor[j];
                i++;
            }
            j++;
        }
        vetor = vetorAux;
    }
}
