
public class Aluno {
	int matricula;
	int idade;
	String nome;
	
	
	public Aluno() {
super();
	}
	
	public Aluno(int matricula, String nome, int idade) {
		this.matricula = matricula;
		this.nome = nome;
		this.idade = idade;
		// TODO Auto-generated constructor stub
	}
	
	public int getMatricula() {
		return matricula;
	}
	
	@Override
	public String toString() {
		return   matricula + ", " + nome + ", " + idade;
	}
	
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
