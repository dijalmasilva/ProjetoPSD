package interfaces;

import entidades.Grupo;

public interface InterfaceGrupoDAO {

	public boolean adicionar(Grupo grupo);// throws PersistenciaException;

	public boolean remover(String s);

	public boolean atualizar(Grupo grupo);

	public Grupo consultarPorId(int idGrupo);
        
        public int retornaMaximo();

}
