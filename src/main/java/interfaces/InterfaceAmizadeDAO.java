
package interfaces;

import java.util.List;

/**
 *
 * @author dijalma
 */
public interface InterfaceAmizadeDAO {
    
    
    public List<Integer> retornaIdDeAmigos(int idUsuario);
    
    public List<Integer> retornaIdDeSolicitacoes(int idUsuario);
    
    public boolean solicitaAmizade(int idUsuarioE, int idUsuarioR);
    
    public boolean cancelaSolicitacao(int idUsuarioR, int idUsuarioE);
    
    public boolean isFriend (int idUsuario, int idVisitante);
    
    public boolean isSolicitado (int idUsuario, int idVisitante);
    
    public boolean aceitaSolicitacao (int idUsuarioR, int idUsuarioE);
    
    public boolean isPendente (int idUsuario, int Visitante);
}
