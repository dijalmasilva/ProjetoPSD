package conexao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import entidades.Usuario;
import gerenciador.GerenciadorUsuario;

public class TestConnexao {
	static Connection conn = null;
	
	public static void main(String args[]){
		
//		Usuario u = new Usuario();
//		GerenciadorUsuario gu = new GerenciadorUsuario();
//		u.setEmail("meuemail@com");;
//		u.setApelido("Zilderln");
		//gu.adicionar(u);
		
		//gu.remover("Zilderln");
		
		
		try {
			testCadastrar();
			//testRemover();
			//testUpdate();
			//testBuscaCompleta();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void testCadastrar() throws SQLException {
		
		Usuario u = new Usuario();
		u.setNome("Zilderlan");
		u.setApelido("Zilder");
		u.setEmail("zilderlan123@email.com");
		u.setSenha("12345");
		u.setCidade("Cachoeira dos �ndios");
		u.setEstado("Para�ba");
		u.setDataNAsc(convData("10/10/2015"));
		GerenciadorUsuario gu = new GerenciadorUsuario();
		gu.adicionar(u);			
		System.out.println("Cadastrado com sucesso!!");
	}
	
	private static void testUpdate() throws SQLException {
		Usuario u = new Usuario();
		GerenciadorUsuario gu = new GerenciadorUsuario();
		u.setNome("iiiiiiiiiiiii");
		u.setApelido("iiiiiiiiii");
		u.setEmail("iiiiiiii");
		u.setCidade("Cachoeira dos �ndios");
		u.setEstado("Para�ba");
		u.setId(4);
		gu.alterar(u);
		System.out.println("Alterado com sucesso!!");
	
		
	}

	private static void testRemover() throws SQLException {

		GerenciadorUsuario gu = new GerenciadorUsuario();
		gu.remover("33333333333");
		System.out.println("Removido com sucesso!!");
	}
	
	private static void testBuscaCompleta() throws SQLException {
	
		Usuario us = new Usuario();
		GerenciadorUsuario gu = new GerenciadorUsuario();
		List<Usuario> resultadoLista = gu.pesquisar();
		for (Usuario u: resultadoLista)
			System.out.println("Id: " + u.getId() + "\nNome: " + u.getNome() + "\nApelido: " + u.getApelido()
					+ "\nCidade: " + u.getCidade() + "\nEstado: " + u.getEstado());
	
	
	}
	
	private static Date convData(String dataStr){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		if (dataStr == null || dataStr.equals("")) return null;
		Date data = null;
		try {
			data = new Date(sdf.parse(dataStr).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
		
	}
}
