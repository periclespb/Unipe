import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TabelaHash tabela = new TabelaHash();		
		int op= 0;
	Scanner sc = new Scanner (System.in);
	while (op != 5) {
			System.out.println("\n------Digite a Opcao------\n1 - Inserir Aluno\n2 - Buscar Aluno\n3 - Remover Aluno\n4 - Exibir Hash\n5 - Sair\n");
			op = sc.nextInt();
			if (op==1) {
				System.out.println("Digite a matricula");
				int mat = sc.nextInt();
				System.out.println("Digite o nome");
				String nome = sc.next();
				System.out.println("Digite a idade");
				int idade = sc.nextInt();
				tabela.inserir(new Aluno (mat, nome, idade));
				
			}else if (op==2) {
				System.out.println("Digite a matricula");
				int mat = sc.nextInt();
				Aluno a = tabela.buscar(mat);
				System.out.println(a.toString());
			}else if (op==3) {
				System.out.println("Digite a matricula");
				int mat = sc.nextInt();
				 tabela.remover(mat);
			}else if (op == 4) {
				tabela.exibir();
			}else if (op == 5) {
				System.out.println("Saindo do Sistema!");
			}
		}
	}

}
