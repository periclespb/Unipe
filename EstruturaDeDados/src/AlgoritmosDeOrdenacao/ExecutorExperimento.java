package AlgoritmosDeOrdenacao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class ExecutorExperimento {

	public static void main(String[] args) throws IOException {

		int limiteSuperior = 100000;
		int totalExecucoes = 30;

		List<IAlgoritmoOrdenacao> algoritmosOrdenacao = new ArrayList<IAlgoritmoOrdenacao>();

		/*
		 * INSERIR NA LISTA OS 5 ALGORITMOS DE ORDENACAO IMPLEMENTADOS.
		 * 
		 * CRIE UM CLASSE PARA REPRESENTAR CADA ALGORITMO DE ORDENACAO. ESSA CLASSE DE
		 * IMPLEMENTAR A INTERFACE IAlgoritmoOrdenacao E SOBRESCREVER O METODO
		 * ordenarVetor.
		 * 
		 */
		algoritmosOrdenacao.add(new BubbleSort());
		algoritmosOrdenacao.add(new SelectionSort());
		algoritmosOrdenacao.add(new InsectionSort());
		algoritmosOrdenacao.add(new MergeSort());
		algoritmosOrdenacao.add(new QuickSort());

		List<Integer> tamanhoVetores = new ArrayList<Integer>();

		tamanhoVetores.add(100);
		tamanhoVetores.add(1000);
		tamanhoVetores.add(5000);
		tamanhoVetores.add(10000);
		tamanhoVetores.add(50000);

		System.out.println("\n\n Iniciando Experimento");
		HashMap<String, String> tabelaArquivo = new HashMap<String, String>();
		for (IAlgoritmoOrdenacao a : algoritmosOrdenacao) {
			tabelaArquivo.put(a.toString(), "");
		}

		for (int tamanhoVetor : tamanhoVetores) {
			System.out.println("\n    Tamanho Vetor: " + tamanhoVetor + "\n");
			HashMap<String, Double> mapTempoExecucoes = new HashMap<String, Double>();
			for (int i = 1; i <= totalExecucoes; i++) {
				int[] vetor = Utils.gerarVetor(tamanhoVetor, limiteSuperior);
				int[] vetorAux = vetor.clone();
				for (IAlgoritmoOrdenacao algoritmoOrdenacao : algoritmosOrdenacao) {
					long tempoInicial = System.currentTimeMillis();
					algoritmoOrdenacao.ordenarVetor(vetor);
					long tempoFinal = System.currentTimeMillis();
					double tempoExecucao = ((tempoFinal - tempoInicial) / 1000.0);
					if (mapTempoExecucoes.containsKey(algoritmoOrdenacao.toString())) {
						tempoExecucao += mapTempoExecucoes.get(algoritmoOrdenacao.toString());
					}
					mapTempoExecucoes.put(algoritmoOrdenacao.toString(), tempoExecucao);
					vetor = vetorAux.clone();
				}

			} // FOR TAMANHO VETORES
			for (Entry<String, Double> entry : mapTempoExecucoes.entrySet()) {
				double mediaTempoExecucoes = entry.getValue() / (1.0 * totalExecucoes);
				System.out.println("      " + entry.getKey() + " -- " + String.format("%.10f", mediaTempoExecucoes));// mediaTempoExecucoes);
				tabelaArquivo.put(entry.getKey(),
						tabelaArquivo.get(entry.getKey()) + "," + String.format("%.10f", mediaTempoExecucoes));
				/*
				 * SALVAR EM UM ARQUIVO DO TIPO .CSV COM O FORMATO:
				 * 
				 * Algoritmo,100,1.000,5.000,10.000,50.000\n
				 * 
				 * CADA LINHA DEVE TER O NOME DO ALGORITMO E O RESPECTIVO TEMPO DE EXECUÇAO
				 * PARA CADA TAMANHO DE VETOR.
				 *
				 */
			}

			System.out.println("\n\n Experimento Finalizado");
		}

		FileWriter arq = new FileWriter("arquivo.csv");
		PrintWriter gravarArq = new PrintWriter(arq);
		System.out.println("Tabela csv\n");
		String tmp = "";
		//criando cabecalho
		tmp = "Algoritmo";
		for (Integer i : tamanhoVetores) {
			tmp+= ","+i;
		}
		gravarArq.printf(tmp+"\n");
		tmp = "";
		for (Entry<String, String> entry : tabelaArquivo.entrySet()) {
			tmp = entry.getKey() + "," + entry.getValue() + "\n";
			tmp = tmp.replace(",,", ",");
			System.out.println(tmp);
			gravarArq.printf(tmp);
		}
		arq.close();
	}

}