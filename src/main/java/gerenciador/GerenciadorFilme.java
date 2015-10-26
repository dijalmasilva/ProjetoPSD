package gerenciador;

import java.util.List;
import entidades.Filme;
import factory.DAOFactory;

public class GerenciadorFilme {

    public boolean adicionar(Filme f) {
        return DAOFactory.createFactory().criaFilmeDAO().add(f);
    }

    public boolean remover(String s) {
        return DAOFactory.createFactory().criaFilmeDAO().delete(null);
    }

    public List<Filme> pesquisar() {
        return DAOFactory.createFactory().criaFilmeDAO().buscar10filmesRecentes();

    }

    public void alterar(Filme f) {
        DAOFactory.createFactory().criaFilmeDAO().update();
    }

}
