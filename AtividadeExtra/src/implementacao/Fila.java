package implementacao;

import java.util.LinkedList;
import java.util.List;

import exceptions.ErroDeAcessoException;

public class Fila<T> {

	private List<T> fila=new LinkedList<T>();
	
	public void add(T t) {
		this.fila.add(t);
	}
	//fila vazia
	public T remove() throws ErroDeAcessoException {
		if(this.fila.size()==0) {
			throw new ErroDeAcessoException("Nao pode remover de uma Fila vazia!");
		}
		return this.fila.remove(0);
	}
	
	public void isVazia() {
		 if(this.fila.size()==0) {
			 System.out.println("A fila esta vazia!");
		 }else {
			 System.out.println("A fila nao esta vazia!");
		 }
	}
	
	public void listar() {
		for(T t:this.fila) {
			System.out.println(t.toString());
		}
	}
}