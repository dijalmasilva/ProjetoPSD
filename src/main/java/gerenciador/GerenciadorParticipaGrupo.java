/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciador;

import entidades.Usuario;
import factory.DAOFactory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dijalma
 */
public class GerenciadorParticipaGrupo {
    
    
    public boolean adicionaRelacaoAdmin(int idUser, int idGrupo){
        return DAOFactory.createFactory().criaParticipaGrupoDAO().adicionaRelacaoAdmin(idUser, idGrupo);
    }
    
    public boolean adicionaRelacao(int idUser, int idGrupo){
        return DAOFactory.createFactory().criaParticipaGrupoDAO().adicionaRelacao(idUser, idGrupo);
    }
    
    public List<Integer> retornaGrupos(int idUser){
        return DAOFactory.createFactory().criaParticipaGrupoDAO().retornaGrupos(idUser);
    }
    
    public boolean isParticipa(int idUsuario, int idGrupo){
        return DAOFactory.createFactory().criaParticipaGrupoDAO().isParticipa(idUsuario, idGrupo);
    }
    
    public List<Usuario> retornaUsuariosDeUmGrupo(int idGrupo){
        List<Usuario> usuarios = new ArrayList<>();
        
        for(Integer i: DAOFactory.createFactory().criaParticipaGrupoDAO().retornaUsuariosDeUmGrupo(idGrupo)){
            usuarios.add(new GerenciadorUsuario().consultarPorId(i));
        }
        
        return usuarios;
    }
}
