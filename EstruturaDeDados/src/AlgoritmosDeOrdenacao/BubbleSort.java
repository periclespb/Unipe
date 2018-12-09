package AlgoritmosDeOrdenacao;

public class BubbleSort implements IAlgoritmoOrdenacao{
	@Override
	public void ordenarVetor(int[] vetor) {
		for(int m=0;m<vetor.length;m++) {
			for(int n=0;n<vetor.length;n++) {
				if(vetor[m]<vetor[n]) {
					int troca=vetor[m];
					vetor[m]=vetor[n];
					vetor[n]=troca;
				}
			}
		}

	}
	@Override
	public String toString() {
		return "BubbleSort";
	}

}
