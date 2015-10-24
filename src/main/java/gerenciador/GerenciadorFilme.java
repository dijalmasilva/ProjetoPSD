package gerenciador;

import DAO.FilmeDAO;
import java.util.List;

import DAO.UsuarioDAO;
import entidades.Filme;
import entidades.Usuario;
import factory.DAOFactory;
import factory.DAOFactoryPSD;

public class GerenciadorFilme {
	
	public boolean adicionar(Filme f){
		DAOFactoryPSD fabrica = DAOFactory.createFactory();
		FilmeDAO filme = fabrica.criaFilmeDAO();
		filme.add(f);
		return true;
	}
	
	public void remover(String s){
		DAOFactoryPSD fabrica = DAOFactory.createFactory();
		FilmeDAO filme = fabrica.criaFilmeDAO();
		filme.delete(null);
		
	}
	
	public List<Filme> pesquisar(){
		DAOFactoryPSD fabrica = DAOFactory.createFactory();
		FilmeDAO filme = fabrica.criaFilmeDAO();
		return filme.buscar();
		
	}
	public void alterar(Filme f) {
		DAOFactoryPSD fabrica = DAOFactory.createFactory();
		FilmeDAO filme = fabrica.criaFilmeDAO();
		filme.update();
	}

}
