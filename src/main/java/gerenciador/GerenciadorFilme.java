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

    public List<Filme> buscarCincoFilmesRecentes() {
        return DAOFactory.createFactory().criaFilmeDAO().buscarCincofilmesRecentes();

    }

    public void alterar(Filme f) {
        DAOFactory.createFactory().criaFilmeDAO().update();
    }

}
