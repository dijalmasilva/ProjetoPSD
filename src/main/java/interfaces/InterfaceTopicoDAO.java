package interfaces;

import entidades.Topico;
import java.util.List;


public interface InterfaceTopicoDAO {
	
	public boolean adicionar(Topico t);//throws PersistenciaException;

	public boolean remover(String s);

	public boolean atualizar(Topico t);

	public List<Topico> consultarIdDoGrupo(int idDoGrupo);

}
