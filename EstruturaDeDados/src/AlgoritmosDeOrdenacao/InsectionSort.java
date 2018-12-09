package AlgoritmosDeOrdenacao;

public class InsectionSort implements IAlgoritmoOrdenacao {

	@Override
	public void ordenarVetor(int[] vetor) {
		for (int i = 1; i < vetor.length; i++) {

			int aux = vetor[i];
			int j = i;

			while ((j > 0) && (vetor[j - 1] > aux)) {
				vetor[j] = vetor[j - 1];
				j -= 1;
			}
			vetor[j] = aux;

		}
	}

	@Override
	public String toString() {
		return "InsectionSort";
	}

}
