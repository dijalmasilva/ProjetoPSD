package factory;

import DAO.AmizadeDAO;
import DAO.AvaliacaoDAO;
import DAO.ComentarioTopicoDAO;
import DAO.FilmeDAO;
import DAO.GrupoDAO;
import DAO.ParticipaGrupoDAO;
import DAO.SolicitacoesDAO;
import DAO.TopicoDAO;
import DAO.UsuarioDAO;

public class DAOFactoryBD implements DAOFactoryPSD {

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
    public ComentarioTopicoDAO criaComentarioTopicoDAO() {
        return new ComentarioTopicoDAO();
    }

    @Override
    public GrupoDAO criaGrupoDAO() {
        return new GrupoDAO();
    }

    @Override
    public TopicoDAO criaTopicoDAO() {
        return new TopicoDAO();
    }

    @Override
    public SolicitacoesDAO criaSolicitacaoDAO() {
        return new SolicitacoesDAO();
    }

    @Override
    public ParticipaGrupoDAO criaParticipaGrupoDAO() {
        return new ParticipaGrupoDAO();
    }
    
    @Override
    public AmizadeDAO criaAmizadeDAO(){
        return new AmizadeDAO();
    }
}
