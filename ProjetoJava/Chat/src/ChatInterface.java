import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

//Como os métodos serão disponibilizados remotamente,
//a interface precisa extender a classe Remote
public interface ChatInterface extends Remote {

	//métodos remotos que serão implementados no servidor,
	//precisam lançar a exceção RemoteException
	public void enviarMensagem(String msgn, String nome) throws RemoteException;
	public ArrayList<String> lerMensagem() throws RemoteException;
	
}
