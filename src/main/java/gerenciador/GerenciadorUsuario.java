package gerenciador;

import java.util.List;

import DAO.UsuarioDAO;
import entidades.Usuario;
import factory.DAOFactory;
import factory.DAOFactoryPSD;

public class GerenciadorUsuario {
	
	public boolean adicionar(Usuario u){
		DAOFactoryPSD fabrica = DAOFactory.createFactory();
		UsuarioDAO usu = fabrica.criaUsuarioDAO();
		return usu.adicionar(u);
	}
	
	public void remover(String s){
		DAOFactoryPSD fabrica = DAOFactory.createFactory();
		UsuarioDAO usu = fabrica.criaUsuarioDAO();
		usu.remover(s);
		
	}
	
	public List<Usuario> pesquisar(){
		DAOFactoryPSD fabrica = DAOFactory.createFactory();
		UsuarioDAO usu = fabrica.criaUsuarioDAO();
		return usu.consultar();
		
	}
	public void alterar(Usuario u) {
		DAOFactoryPSD fabrica = DAOFactory.createFactory();
		UsuarioDAO usu = fabrica.criaUsuarioDAO();
		usu.atualizar(u);
		
	}
        
        public Usuario login(String email, String senha){
                DAOFactoryPSD fabrica = DAOFactory.createFactory();
                UsuarioDAO usu = fabrica.criaUsuarioDAO();
                return usu.login(email, senha);
        }


}
