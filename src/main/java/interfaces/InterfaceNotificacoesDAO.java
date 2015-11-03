/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Notificacoes;
import java.util.List;

/**
 *
 * @author dijalma
 */
public interface InterfaceNotificacoesDAO {
    
    public boolean adicionarRecomendacao(Notificacoes n);
    
    public boolean adicionarSolicitacaoAceita(Notificacoes n);
    
    public List<Notificacoes> recuperar20NotificacoesRecentes(int idUsuario);
}
