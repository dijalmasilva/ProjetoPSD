package interfaces;

import java.util.List;

import entidades.Usuario;

public interface InterfaceUsuarioDAO {

	public boolean adicionar(Usuario usuario);//throws PersistenciaException;

	public boolean remover(String s);

	public boolean atualizar(Usuario usuario);

	public List<Usuario> consultar();
        
        public Usuario login(String email, String senha);

}
