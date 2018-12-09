package implementacao;

import java.util.LinkedList;

import exceptions.ErroDeAcessoException;

public class Pilha<T> {
	 private LinkedList<T> pilha = new LinkedList<T>();

	  public void push(T t) {
	    this.pilha.add(t);
	  }
// pilha vazia
	  public T pop() throws ErroDeAcessoException {
		  if(this.pilha.size() == 0) {
			  throw new ErroDeAcessoException("Nao eh possivel remover de uma pilha vazia!");
		  }
	    return this.pilha.remove(this.pilha.size() - 1);
	  }

	  public void isEmpty() {
			if(this.pilha.size() == 0) {
				System.out.println("Esta vazio!");
			} else{
				System.out.println("Nao esta vazio!");
			}
		}
	  
	  public void listar() {
			for(T t : this.pilha)
				System.out.println(t);
		}

}
