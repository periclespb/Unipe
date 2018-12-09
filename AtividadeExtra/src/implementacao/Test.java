package implementacao;

import exceptions.ErroDeAcessoException;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fila<String> fila=new Fila<String>();
		Pilha<String> pilha=new Pilha<String>();
		Deque<String> deque=new Deque<String>();
		
		System.out.println("Testando a fila:\nAqui deve ser lancado uma exception");
		try {
			fila.remove();
		} catch (ErroDeAcessoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Aqui adicionamos um valor:");
		fila.add("Fulano");
		fila.listar();
		System.out.println("Agora vamos remover de uma lista nao vazia");
		try {
			fila.remove();
		} catch (ErroDeAcessoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Acima nao pode ter exception");
		System.out.println("\n");
		System.out.println("Agora vamos testar a Pilha:");
		System.out.println("Aqui deve ser lancado uma exception");
		try {
			pilha.pop();
		} catch (ErroDeAcessoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Aqui adicionamos um valor:");
		pilha.push("Cicrano");
		pilha.listar();
		System.out.println("Agora vamos remover de uma pilha nao vazia");
		try {
			pilha.pop();
		} catch (ErroDeAcessoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Acima nao pode ter exception");
		System.out.println("\n");
		System.out.println("Agora vamos testar um Deque:");
		System.out.println("Aqui deve ser lancado uma exception, tentando remover o primeiro elemento");
		try {
			deque.removeFirst();
		} catch (ErroDeAcessoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n");
		System.out.println("Aqui deve ser lancado uma exception, tentando remover o ultimo elemento");
		try {
			deque.removeLast();
		} catch (ErroDeAcessoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Aqui adicionamos dois valores:");
		deque.addFirst("Monica");
		deque.addLast("Cebolinha");
		deque.listar();
		System.out.println("Agora vamos remover de um Deque nao vazia, removendo o primeiro elemento");
		try {
			deque.removeFirst();
		} catch (ErroDeAcessoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		deque.listar();
		System.out.println("Acima nao pode ter exception");
		System.out.println("Agora vamos remover de um Deque nao vazia, removendo o ultimo elemento");
		try {
			deque.removeLast();
		} catch (ErroDeAcessoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		deque.listar();
		System.out.println("Acima nao pode ter exception");
	}

}
