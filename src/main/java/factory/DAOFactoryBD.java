package factory;

import DAO.AutorFilmeDAO;
import DAO.AvaliacaoDAO;
import DAO.ComentarioAvaliacaoDAO;
import DAO.ComentarioDAO;
import DAO.ComentarioTopicoDAO;
import DAO.DiretorFilmeDAO;
import DAO.FilmeDAO;
import DAO.GeneroFilmeDAO;
import DAO.GrupoDAO;
import DAO.TopicoDAO;
import DAO.UsuarioDAO;
import entidades.Filme;

public class DAOFactoryBD implements DAOFactoryPSD{

	
	public UsuarioDAO criaUsuarioDAO() {
		return new UsuarioDAO();
	}

	
	public FilmeDAO criaFilmeDAO() {
		return new FilmeDAO();
	}

	
	public AvaliacaoDAO criaAvaliacaoDAO() {
		return new AvaliacaoDAO();
	}

	
	public AutorFilmeDAO criaAutorFilmeDAO() {
		return new AutorFilmeDAO();
	}

	
	public ComentarioAvaliacaoDAO criaComentarioAvaliacaoDAO() {
		return new ComentarioAvaliacaoDAO();
	}

	
	public ComentarioDAO criaComentarioDAO() {
		return new ComentarioDAO();
	}

	
	public GeneroFilmeDAO criaGenereoFilmeDAO() {
		return new GeneroFilmeDAO();
	}

	
	public ComentarioTopicoDAO criaComentarioTopicoDAO() {
		return new ComentarioTopicoDAO();
	}

	
	public DiretorFilmeDAO criaDiretorFilmeDAO() {
		return new DiretorFilmeDAO();
	}

	
	public GrupoDAO criaGrupoDAODAO() {
		return new GrupoDAO();
	}

	
	public TopicoDAO criaTopicoDAODAO() {
		return new TopicoDAO();
	}

}
