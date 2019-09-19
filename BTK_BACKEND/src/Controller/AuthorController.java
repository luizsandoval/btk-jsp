package Controller;

import java.sql.SQLException;
import java.util.ArrayList;

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

    public AuthorBean buscarAutorPorID(AuthorBean author) throws SQLException, ClassNotFoundException {
        return this.authorDAO.getAuthorByID(author.getId());
    }

    public ArrayList<AuthorBean> buscarTodosOsAutores() throws SQLException, ClassNotFoundException {
        return this.authorDAO.listAll();
    }

}
