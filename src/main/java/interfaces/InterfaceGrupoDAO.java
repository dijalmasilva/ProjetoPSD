package interfaces;

import entidades.Grupo;

public interface InterfaceGrupoDAO {

	public boolean adicionar(Grupo grupo);// throws PersistenciaException;

	public boolean remover(int idGrupo);

	public boolean atualizar(Grupo grupo);

	public Grupo consultarPorId(int idGrupo);
        
        public int retornaMaximo();

}
