package Controller;

import java.sql.SQLException;
import java.util.List;

import DAO.AuthorDAO;
import Model.AuthorBean;

public class AuthorController {

    final private AuthorDAO authorDAO;

    public AuthorController() throws SQLException, ClassNotFoundException {
        this.authorDAO = new AuthorDAO();
    }

    public boolean adicionarAutor(AuthorBean author) throws SQLException, ClassNotFoundException {
        return this.authorDAO.create(author);
    }

    public boolean editarAutor(AuthorBean author) throws SQLException, ClassNotFoundException {
        return this.authorDAO.edit(author);
    }

    public boolean removerAutor(AuthorBean author) throws SQLException, ClassNotFoundException {
        return this.authorDAO.delete(author);
    }

    public List<AuthorBean> buscarTodosOsAutores() throws SQLException, ClassNotFoundException {
        return this.authorDAO.listAll();
    }

}
