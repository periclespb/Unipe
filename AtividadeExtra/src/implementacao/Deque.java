package implementacao;

import java.util.LinkedList;
import java.util.List;

import exceptions.ErroDeAcessoException;

public class Deque<T> {
	
	private List<T> deque;
	
	public Deque() {
		this.deque=new LinkedList<T>();
	}
//remover na lista vazia	
	public T removeFirst() throws ErroDeAcessoException {
		if(this.deque.size() == 0) {
			throw new ErroDeAcessoException("Erro ao remover o primeiro elemento de um Deque vazio");
		}
		return this.deque.remove(0);
	}
	//remover na lista vazia
	public T removeLast() throws ErroDeAcessoException {
		if(this.deque.size() == 0) {
			throw new ErroDeAcessoException("Erro ao remover o ultimo elemento de um Deque vazio");
		}
		return this.deque.remove(this.deque.size() - 1);
	}
	
	public void addLast(T t){
		this.deque.add(t);
	}
	
	public void addFirst(T t) {
		this.deque.add(0,t);
	}
	
	public void isEmpty() {
		if(this.deque.size() == 0) {
			System.out.println("Esta vazio!");
		} else{
			System.out.println("Nao esta vazio!");
		}
	}

	public void listar() {
		for(T t : this.deque)
			System.out.println(t.toString());
	}
}