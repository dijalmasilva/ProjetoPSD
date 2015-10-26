package gerenciador;

import java.util.List;
import entidades.Grupo;
import factory.DAOFactory;

public class GerenciadorGrupo {

    public boolean adicionar(Grupo grupo) {
        return DAOFactory.createFactory().criaGrupoDAO().adicionar(grupo);
    }

    public boolean remover(String s) {
        return DAOFactory.createFactory().criaGrupoDAO().remover(s);
    }

    public List<Grupo> pesquisar() {
        return DAOFactory.createFactory().criaGrupoDAO().consultar();
    }

    public void alterar(Grupo grupo) {
        DAOFactory.createFactory().criaGrupoDAO().atualizar(grupo);
    }

}
