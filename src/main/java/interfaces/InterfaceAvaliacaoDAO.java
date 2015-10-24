package interfaces;

import entidades.Avaliacao;
import java.util.List;


public interface InterfaceAvaliacaoDAO {
	
	public boolean adicionar(Avaliacao a);//throws PersistenciaException;

	public boolean atualizar(Avaliacao a);

	public List<Avaliacao> consultarPorIdDeFilme(int idFilme);

}
