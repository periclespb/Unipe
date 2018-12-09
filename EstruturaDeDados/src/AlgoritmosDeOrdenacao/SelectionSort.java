package AlgoritmosDeOrdenacao;


public class SelectionSort implements IAlgoritmoOrdenacao {

	@Override
	public void ordenarVetor(int[] vetor) {
		for (int i = 0; i < vetor.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < vetor.length; j++) {
				if (vetor[j] < vetor[index]) {
					index = j;
				}

			}
			int menor = vetor[index];
			vetor[index] = vetor[i];
			vetor[i] = menor;
		}
		
	}

	@Override
	public String toString() {
		return "SelectionSort";
	}
}
