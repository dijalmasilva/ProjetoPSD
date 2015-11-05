package gerenciador;

import java.util.List;

import entidades.Usuario;
import factory.DAOFactory;
import java.util.ArrayList;

public class GerenciadorUsuario {

    public boolean adicionar(Usuario u) {
        return DAOFactory.createFactory().criaUsuarioDAO().adicionar(u);
    }

    public boolean remover(int id) {
        return DAOFactory.createFactory().criaUsuarioDAO().remover(id);
    }

    public List<Usuario> consultarPorApelido(String apelido, int idUsuario) {
        return DAOFactory.createFactory().criaUsuarioDAO().consultarPorApelido(apelido, idUsuario);
    }

    public Usuario consultarPorEmail(String email, int idUsuario){
        return DAOFactory.createFactory().criaUsuarioDAO().consultarPorEmail(email, idUsuario);
    }
    
    public Usuario consultarPorId(int id){
        return DAOFactory.createFactory().criaUsuarioDAO().consultarPorId(id);
    }
    
    public boolean alterar(Usuario u) {
        return DAOFactory.createFactory().criaUsuarioDAO().atualizar(u);
    }

    public Usuario login(String email, String senha) {
        return DAOFactory.createFactory().criaUsuarioDAO().login(email, senha);
    }
    
    public boolean atualizarParaAdministrador(int id){
        return DAOFactory.createFactory().criaUsuarioDAO().atualizarParaAdministrador(id);
    }

    public List<Usuario> retornaUsuariosPorIds(List<Integer> idAmigos){
        List<Usuario> usuarios = new ArrayList<>();
        
        for (Integer i: idAmigos){
            usuarios.add(consultarPorId(i));
        }
        
        return usuarios;
    }
    
    public String retornaFotoPeloId(int id){
        return DAOFactory.createFactory().criaUsuarioDAO().retornaFotoPeloId(id);
    }
    
    public String retornaApelidoPeloId(int id){
        return DAOFactory.createFactory().criaUsuarioDAO().retornaApelidoPeloId(id);
    }
    
    
}
