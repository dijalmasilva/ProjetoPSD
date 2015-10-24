package factory;


import DAO.AvaliacaoDAO;
import DAO.ComentarioTopicoDAO;
import DAO.FilmeDAO;
import DAO.GrupoDAO;
import DAO.SolicitacoesDAO;
import DAO.TopicoDAO;
import DAO.UsuarioDAO;

public interface DAOFactoryPSD {

	public UsuarioDAO criaUsuarioDAO();

	public FilmeDAO criaFilmeDAO();
	
	public AvaliacaoDAO criaAvaliacaoDAO();
	
	public ComentarioTopicoDAO criaComentarioTopicoDAO();
	
	public GrupoDAO criaGrupoDAO();
	
	public TopicoDAO criaTopicoDAO();
        
        public SolicitacoesDAO criaSolicitacaoDAO();
}
