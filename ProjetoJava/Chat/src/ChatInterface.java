import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

//Como os m�todos ser�o disponibilizados remotamente,
//a interface precisa extender a classe Remote
public interface ChatInterface extends Remote {

	//m�todos remotos que ser�o implementados no servidor,
	//precisam lan�ar a exce��o RemoteException
	public void enviarMensagem(String msgn, String nome) throws RemoteException;
	public ArrayList<String> lerMensagem() throws RemoteException;
	
}
