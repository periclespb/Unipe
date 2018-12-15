import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Cliente {
	
	public static void main(String[] args) {
		
		try {
			Remote obj = Naming.lookup("//127.0.0.1/chat"); //localiza o servidor para acessar os serviços remotos
			System.out.println("Recurso localizado em //127.0.0.1/chat");
			ChatInterface objRemoto = (ChatInterface) obj; //Converte o objeto Remote em um objeto de ChatInterface
			
			String nome;
			String msg = "";
			Scanner leitor = new Scanner(System.in);
			//Lendo o nickname
			System.out.print("Digite seu nome: ");
			nome = leitor.nextLine();
			
			//Linhas de código que serão executadas em paralelo e vão capturar as mensagens enviadas
			Thread t = new Thread(new Runnable() {
				int cont = objRemoto.lerMensagem().size();
				@Override
				public void run() {
					while(true){
						try {
							//se o tamanho do arraylist no servidor ficar maior que cont
							//imprima a última mensagem recebida e incremente uma unidade no cont
							if(objRemoto.lerMensagem().size() > cont){
								System.out.println(objRemoto.lerMensagem().get(objRemoto.lerMensagem().size()-1));
								cont++;
							}
						} catch(RemoteException e){
						}
					}
				}
			});
			
			t.start(); //inicia a thread
			
			while(true){
				msg = leitor.nextLine(); //Lê a mensagem que será enviada
				//se o usuário enviar exit, pare o envio de mensagens
				if(msg.equals("exit"))
					break;
				//envia para o servidor a mensagem e o nick
				objRemoto.enviarMensagem(msg, nome);
			}
			
			leitor.close();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			System.out.println("Não foi possível conectar-se ao servidor!");
		}

	}

}
