package interfaces;


import entidades.Usuario;
import java.util.List;

public interface InterfaceUsuarioDAO {

	public boolean adicionar(Usuario usuario);//throws PersistenciaException;

	public boolean remover(String s);

	public boolean atualizar(Usuario usuario);

	public Usuario consultarPorId(int id);
        
        public List<Usuario> consultarPorApelido(String apelido);
        
        public Usuario consultarPorEmail(String email);
        
        public Usuario login(String email, String senha);

}
