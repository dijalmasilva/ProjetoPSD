/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;

/**
 *
 * @author dijalma
 */
public interface InterfaceParticipaGrupoDAO{
    
    
    public boolean adicionaRelacaoAdmin(int idUser, int idGrupo);
    
    public boolean adicionaRelacao(int idUser, int idGrupo);
    
    public List<Integer> retornaGrupos(int idUser);
    
    public boolean isParticipa(int idUsuario, int idGrupo);
    
    public List<Integer> retornaUsuariosDeUmGrupo(int idGrupo);
}
