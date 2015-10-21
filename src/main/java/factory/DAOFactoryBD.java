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

public class DAOFactoryBD implements DAOFactoryPSD{

	
        @Override
	public UsuarioDAO criaUsuarioDAO() {
		return new UsuarioDAO();
	}

	
        @Override
	public FilmeDAO criaFilmeDAO() {
		return new FilmeDAO();
	}

	
        @Override
	public AvaliacaoDAO criaAvaliacaoDAO() {
		return new AvaliacaoDAO();
	}

	
        @Override
	public AutorFilmeDAO criaAutorFilmeDAO() {
		return new AutorFilmeDAO();
	}

	
        @Override
	public ComentarioAvaliacaoDAO criaComentarioAvaliacaoDAO() {
		return new ComentarioAvaliacaoDAO();
	}

	
        @Override
	public ComentarioDAO criaComentarioDAO() {
		return new ComentarioDAO();
	}

	
        @Override
	public GeneroFilmeDAO criaGenereoFilmeDAO() {
		return new GeneroFilmeDAO();
	}

	
        @Override
	public ComentarioTopicoDAO criaComentarioTopicoDAO() {
		return new ComentarioTopicoDAO();
	}

	
        @Override
	public DiretorFilmeDAO criaDiretorFilmeDAO() {
		return new DiretorFilmeDAO();
	}

	
        @Override
	public GrupoDAO criaGrupoDAODAO() {
		return new GrupoDAO();
	}

	
        @Override
	public TopicoDAO criaTopicoDAODAO() {
		return new TopicoDAO();
	}

}
