package interfaces;

import entidades.Grupo;
import java.util.List;

public interface InterfaceGrupoDAO {

	public boolean adicionar(Grupo grupo);// throws PersistenciaException;

	public boolean remover(String s);

	public boolean atualizar(Grupo grupo);

	public List<Grupo> consultar();

}
