package gerenciador;

import DAO.GrupoDAO;
import java.util.List;
import entidades.Grupo;
import factory.DAOFactory;
import factory.DAOFactoryPSD;

public class GerenciadorGrupo {
	
	public boolean adicionar(Grupo grupo){
		DAOFactoryPSD fabrica = DAOFactory.createFactory();
		GrupoDAO g = fabrica.criaGrupoDAO();
		g.adicionar(grupo);
		return true;
	}
	
	public void remover(String s){
		DAOFactoryPSD fabrica = DAOFactory.createFactory();
		GrupoDAO g = fabrica.criaGrupoDAO();
		g.remover(s);
		
	}
	
	public List<Grupo> pesquisar(){
		DAOFactoryPSD fabrica = DAOFactory.createFactory();
		GrupoDAO g = fabrica.criaGrupoDAO();
		return g.consultar();
		
	}
	public void alterar(Grupo grupo) {
		DAOFactoryPSD fabrica = DAOFactory.createFactory();
		GrupoDAO g = fabrica.criaGrupoDAO();
		g.atualizar(grupo);
		
	}

}
