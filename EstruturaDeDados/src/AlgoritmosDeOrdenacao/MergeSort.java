package AlgoritmosDeOrdenacao;

public class MergeSort implements IAlgoritmoOrdenacao {
	int[] vetor;

	@Override
	public void ordenarVetor(int[] vetor) {
		sort(vetor, 0, vetor.length - 1);

	}

	public void sort(int[] vetor, int inicio, int fim) {

		if (inicio < fim && inicio >= 0 && fim < vetor.length && vetor.length != 0) {
			int meio = ((fim + inicio) / 2);

			sort(vetor, inicio, meio);
			sort(vetor, meio + 1, fim);
			merge(vetor, inicio, meio, fim);
			this.vetor = vetor;
		}
	}

	public void merge(int[] vetor, int inicio, int meio, int fim) {

		int[] vetor_aux = new int[vetor.length];
		for (int i = inicio; i <= fim; i++) {
			vetor_aux[i] = vetor[i];
		}

		int m = inicio;
		int n = meio + 1;
		int o = inicio;

		while (m <= meio && n <= fim) {
			if (vetor_aux[m] < (vetor_aux[n])) {
				vetor[o] = vetor_aux[m];
				m++;
			} else {
				vetor[o] = vetor_aux[n];
				n++;
			}
			o++;
		}

		while (m <= meio) {
			vetor[o] = vetor_aux[m];
			m++;
			o++;
		}

		while (n <= fim) {
			vetor[o] = vetor_aux[n];
			n++;
			o++;
		}
	}

	public String toString() {
		return "MergeSort" ;
		
	}
}
