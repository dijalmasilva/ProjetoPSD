package interfaces;


import entidades.Usuario;
import java.util.List;

public interface InterfaceUsuarioDAO {

	public boolean adicionar(Usuario usuario);//throws PersistenciaException;

	public boolean remover(int id);

	public boolean atualizar(Usuario usuario);

	public Usuario consultarPorId(int id);
        
        public List<Usuario> consultarPorApelido(String apelido, int idUsuario);
        
        public Usuario consultarPorEmail(String email, int idUsuario);
        
        public Usuario login(String email, String senha);
        
        public boolean atualizarParaAdministrador(int id);

        public String retornaFotoPeloId(int id);
        
        public String retornaApelidoPeloId(int id);
}
