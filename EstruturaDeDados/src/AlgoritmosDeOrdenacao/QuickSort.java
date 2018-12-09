package AlgoritmosDeOrdenacao;

public class QuickSort implements IAlgoritmoOrdenacao {
	@Override
	public void ordenarVetor(int[] vetor) {
		quickSort (vetor, 0, vetor.length-1);
	}

	public int dividir(int v[], int p, int maior) {
		int j = p - 1;
		int aux = v[maior];
		for (int i = p; i <= maior; i++) {
			if (v[i] <= aux) {
				int au = v[i];
				j++;
				v[i] = v[j];
				v[j] = au;
			}
		}
		return j;

	}

	public void quickSort(int v[], int i, int j) {
		if (i < j) {
			int p = dividir(v, i, j);
			quickSort(v, i, p - 1);
			quickSort(v, p + 1, j);
			
		}
	}

	@Override
	public String toString() {
		return "QuickSort";
	}

}
