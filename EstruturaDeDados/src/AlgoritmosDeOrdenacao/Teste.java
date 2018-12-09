package AlgoritmosDeOrdenacao;

/*
 * Classe feita para testar os algoritimos
 */

public class Teste {
	public static void main(String args[]) {
		 int vetor[] = { 10, 14, 13, 49, 0, 1, 100,12, 300,200,3 };

		IAlgoritmoOrdenacao b = new SelectionSort();
		Utils.imprimirVetor(vetor);
		b.ordenarVetor(vetor);
		System.out.println("-----\n" + b.toString());
	}
}
