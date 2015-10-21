package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexao {
	
	
	private static Connection conn = null;
	
	private static PreparedStatement stm =  null;
	
	
	public static Connection abrirConexao() throws ClassNotFoundException, SQLException{
		return abrirConexaoBanco("localhost", "DataBasePSD", "postgres", "manoeldj20");
	}

	public static Connection abrirConexaoBanco(String server, String dataBase, String user, String password) throws ClassNotFoundException, SQLException{
		Class.forName("org.postgresql.Driver");
		conn = DriverManager.getConnection("jdbc:postgresql://" + server + ":5432/" + dataBase, user, password);
		return conn;
	}
	
	public static void fecharConexao(Connection conn){
		if (conn!= null)
			try{
			conn.close();
			System.out.println("Fechando!!!");
			} catch(SQLException e){
				System.out.println("Erro: " + e.getMessage());
			}
	}
	
	public static PreparedStatement abrirStatement (String sql){
		
		try {
			stm = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stm;
	}
	
	public static boolean fecharStatment(PreparedStatement stm){
		if (stm != null)//Obs.: N�o sei o que o PreparedStatement retorna
		try{
			stm.close();
			return true;
		}catch(SQLException e){
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}
			
		
		return false;
	}
	
	/*
	 public static int delete(String s, Usuario u) throws SQLException {
	        PreparedStatement stm = conn.prepareStatement(s);
	        stm.setInt(1, u.getId());
	        return stm.executeUpdate();
	    }
	    */
}
