import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TabelaHash {
	
	private final int M=11;//Tamanho da Tabela
	
	ArrayList<LinkedList> tabela=new ArrayList<LinkedList>(M);
	
	
	
	public TabelaHash() {
		super();
		for(int i=0;i<M;i++) {//Inicia a LinkedList
			tabela.add(new LinkedList<Aluno>());
		}
	}
	
	public int FuncaoTransf(int matricula) {
		
		return matricula%M;//funcao de transformacao
	}

	public void inserir(Aluno aluno) {
		List<Aluno> lista;
		lista=tabela.get(FuncaoTransf(aluno.getMatricula()));//Pega a lista de um indice da tabela
		for (Aluno a : lista) {
			if (a.getMatricula() == aluno.getMatricula()) {//Verifica se a matricula ja existe
				System.out.println("Ja existe essa matricula no sistema");
				return ;
			}
		}
		lista.add(aluno);//Add Aluno
	}
	
	public Aluno buscar(int matricula) {
		List<Aluno> lista;
		lista=tabela.get(FuncaoTransf(matricula));//Pega a lista de um indice da tabela
		for(Aluno a:lista)	{
			if(a.getMatricula()==matricula) {//Busca a matricula
				return a;
			}
		}
		return null;	
	}
	
	public void remover(int matricula) {
		List<Aluno> lista;
		lista=tabela.get(FuncaoTransf(matricula));
		for(Aluno a:lista)	{
			if(a.getMatricula()==matricula) {
				lista.remove(a);//Remove o Aluno
			}
		}
	}
	
	public void exibir () {
		String exibir=" Tabela Hash \n";
		for  (int i =0 ; i< M;i++) {//pecorre a lista
			LinkedList<Aluno> a = tabela.get(i);
			for (Aluno aluno: a) {
				exibir += "["+i+ "] - "+ aluno.toString() + "\n";
			}
		}
		System.out.println(exibir);//Exibe a tabela
		
	}

}
