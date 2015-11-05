package gerenciador;

import java.util.List;
import entidades.Grupo;
import factory.DAOFactory;
import java.util.ArrayList;

public class GerenciadorGrupo {

    public boolean adicionar(Grupo grupo) {
        return DAOFactory.createFactory().criaGrupoDAO().adicionar(grupo);
    }

    public boolean remover(String s) {
        return DAOFactory.createFactory().criaGrupoDAO().remover(s);
    }

    public List<Grupo> retornaGruposDoUsuario(int idUser) {
        List<Grupo> grupos = new ArrayList<>();
        for (Integer id : new GerenciadorParticipaGrupo().retornaGrupos(idUser)) {
            grupos.add(DAOFactory.createFactory().criaGrupoDAO().consultarPorId(id));
        }
        
        return grupos;
    }

    public Grupo consultarPorId(int idGrupo){
        return DAOFactory.createFactory().criaGrupoDAO().consultarPorId(idGrupo);
    }
    
    public void alterar(Grupo grupo) {
        DAOFactory.createFactory().criaGrupoDAO().atualizar(grupo);
    }

    public boolean adicionaRelacao(int idUser, int idGrupo){
        return DAOFactory.createFactory().criaParticipaGrupoDAO().adicionaRelacao(idUser, idGrupo);
    }
    
    public boolean adicionaRelacaoAdmin(int idUser, int idGrupo){
        return DAOFactory.createFactory().criaParticipaGrupoDAO().adicionaRelacaoAdmin(idUser, idGrupo);
    }
    
    public int retornaMaximo(){
        return DAOFactory.createFactory().criaGrupoDAO().retornaMaximo();
    }

}
