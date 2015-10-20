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

public interface DAOFactoryPSD {

	public UsuarioDAO criaUsuarioDAO();

	public FilmeDAO criaFilmeDAO();
	
	public AvaliacaoDAO criaAvaliacaoDAO();
	
	public AutorFilmeDAO criaAutorFilmeDAO();

	public ComentarioAvaliacaoDAO criaComentarioAvaliacaoDAO();
	
	public ComentarioDAO criaComentarioDAO();
	
	public GeneroFilmeDAO criaGenereoFilmeDAO();
	
	public ComentarioTopicoDAO criaComentarioTopicoDAO();
	
	public DiretorFilmeDAO criaDiretorFilmeDAO();
	
	public GrupoDAO criaGrupoDAODAO();
	
	public TopicoDAO criaTopicoDAODAO();
}
