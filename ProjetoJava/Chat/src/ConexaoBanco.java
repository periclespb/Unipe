import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoBanco {

	public static Connection getConexao(){
		String url = "jdbc:mysql://localhost:3306/projeto?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user = "root";
		String password = "trick69";
		try {
			return DriverManager.getConnection(url, user, password); //localiza o driver e retorna um connection
		} catch (SQLException e) {
			System.out.println("N�o foi poss�vel conectar-se a base de dados!");
		}
		return null; //caso haja falha ao se conectar retorna null
	}
	
	public static void fecharConexao(Connection con){
		try {
			if(con != null)
				con.close(); //se o connection n�o for null, feche o connection
			else
				System.out.println("Erro ao fechar conex�o!");
		} catch (SQLException e) {
			System.out.println("Erro ao fechar conex�o!");
		}
	}
	
	public static void fecharConexao(Connection con, Statement stmt){
		fecharConexao(con); //fecha o connection
		try {
			if(stmt != null)
				stmt.close(); //se o statement n�o for null, feche o statement
			else
				System.out.println("Erro ao fechar conex�o!");
		} catch (SQLException e) {
			System.out.println("Erro ao fechar conex�o!");
		}
	}

}
