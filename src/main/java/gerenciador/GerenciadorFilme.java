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

    public List<Filme> buscarDezFilmesRecentes() {
        return DAOFactory.createFactory().criaFilmeDAO().buscarDezFilmesRecentes();

    }

    public List<Filme> buscarFilmesPorGeneros(String genero) {
        return DAOFactory.createFactory().criaFilmeDAO().buscarFilmesPorGeneros(genero);
    }

    public List<Filme> buscarFilmesPorAtoresPrincipais(String atoresPrincipal) {
        return DAOFactory.createFactory().criaFilmeDAO().buscarFilmesPorAtoresPrincipais(atoresPrincipal);
    }

    public List<Filme> buscarFilmesPorDiretores(String diretor) {
        return DAOFactory.createFactory().criaFilmeDAO().buscarFilmesPorDiretores(diretor);
    }

    public void alterar(Filme f) {
        DAOFactory.createFactory().criaFilmeDAO().update();
    }

    public Filme buscarFilmePorId(int id){
        return DAOFactory.createFactory().criaFilmeDAO().buscarFilmePorId(id);
    }
    
    public String buscarTituloDoFilmePorId(int id){
        return DAOFactory.createFactory().criaFilmeDAO().buscarTituloDoFilmePorId(id);
    }
    
    public List<String> retornaTodosOsFilmes(){
        return DAOFactory.createFactory().criaFilmeDAO().retornaTodosOsFilmes();
    }
}
