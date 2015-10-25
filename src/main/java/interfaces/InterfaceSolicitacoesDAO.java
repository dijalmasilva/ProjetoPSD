package interfaces;

import entidades.Solicitacoes;
import java.util.List;


public interface InterfaceSolicitacoesDAO {
	
	public boolean adicionar(Solicitacoes s);//throws PersistenciaException;

	public boolean atualizar(Solicitacoes s);

	public List<Solicitacoes> consultarPorIdDoUsuario(int idUsuario);

}
