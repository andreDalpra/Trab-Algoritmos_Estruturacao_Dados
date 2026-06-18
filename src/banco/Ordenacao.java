/*
package banco;

public class Ordenacao<T extends Comparable<T>> {

    private T[] info;

    public Ordenacao(T[] p_info) {
        info = p_info;
    }

    public void mergeSort() {
        int n = info.length - 1;
        mergeSort(0, n);
    }

    private void mergeSort(int p_inicio, int p_fim) {
        if (p_inicio < p_fim) {
            int l_meio = (p_inicio + p_fim) / 2;

            mergeSort(p_inicio, l_meio);
            mergeSort(l_meio + 1, p_fim);
            merge(p_inicio, p_fim, l_meio);
        }
    }

    @SuppressWarnings("unchecked")
    private void merge(int p_inicio, int p_fim, int p_meio) {
        int l_tamEsquerda = p_meio - p_inicio + 1;
        T[] l_esquerda =
            (T[]) new Comparable[l_tamEsquerda];

        for (int i = 0; i < l_tamEsquerda; i++) {
            l_esquerda[i] = info[p_inicio + i];
        }

        int l_tamDireita = p_fim - p_meio;
        T[] l_direita =
            (T[]) new Comparable[l_tamDireita];

        for (int i = 0; i < l_tamDireita; i++) {
            l_direita[i] = info[p_meio + 1 + i];
        }

        int l_cEsq = 0;
        int l_cDir = 0;
        int i = p_inicio;

        while (l_cEsq < l_tamEsquerda &&
               l_cDir < l_tamDireita) {

            if (l_esquerda[l_cEsq]
                    .compareTo(l_direita[l_cDir]) <= 0) {

                info[i] = l_esquerda[l_cEsq];
                l_cEsq++;
            } else {
                info[i] = l_direita[l_cDir];
                l_cDir++;
            }

            i++;
        }

        while (l_cEsq < l_tamEsquerda) {
            info[i] = l_esquerda[l_cEsq];
            l_cEsq++;
            i++;
        }

        while (l_cDir < l_tamDireita) {
            info[i] = l_direita[l_cDir];
            l_cDir++;
            i++;
        }
    }
}
*/