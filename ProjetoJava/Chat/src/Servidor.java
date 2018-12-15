import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//Como o Servidor vai implementar os métodos remotos de ChatInterface,
//ele precisa extender a classe UnicastRemoteObject e implementar a interface
public class Servidor extends UnicastRemoteObject implements ChatInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;//identificador
	
	ArrayList<String> mensagens;

	public Servidor() throws RemoteException {
		super();
		this.mensagens = new ArrayList<String>();
	}
	
	@Override
	public void enviarMensagem(String msgn, String nome) throws RemoteException {
		String sql = "INSERT INTO chat VALUES('" + nome + "', '" + msgn + "');"; //Comando sql de inserção de dados
		Connection con = ConexaoBanco.getConexao(); //Conectando ao banco
		try {
			if(con != null){ //se o connection não for null
				Statement stmt = con.createStatement(); //Criando um statement
				stmt.executeUpdate(sql); //Executando o comando sql
				ConexaoBanco.fecharConexao(con, stmt); //Fechando o connection e o statement
			} else {
				System.out.println("Erro ao salvar mensagem na base de dados!");
			}
		} catch (SQLException e) {
			System.out.println("Erro ao salvar mensagem na base de dados!");
		}
		msgn = nome + ": " + msgn; //Juntando o nome com a mensagem
		mensagens.add(msgn); //Adiciona a mensagem ao arraylist
	}
	
	@Override
	public ArrayList<String> lerMensagem() throws RemoteException {
		return mensagens; //retorna todo o arraylist
	}
	
	public static void main(String[] args) {
		
		System.out.println("Servidor iniciado!");
		try {
			Servidor sr = new Servidor(); //Criando um objeto de Servidor
			Naming.rebind("//127.0.0.1/chat", sr); //Disponibilizando os serviços pelo localhost
			System.out.println("Recurso disponibilizado em /chat");
		} catch (RemoteException e) {
			System.out.println("Erro ao disponibilizar serviços!");
		} catch (MalformedURLException e) {
			System.out.println("Erro na URL!");
		}
		
	}

}
