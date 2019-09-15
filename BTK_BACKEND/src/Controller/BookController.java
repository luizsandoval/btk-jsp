package Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.BookDAO;
import Model.BookBean;

public class BookController {

    final private BookDAO bookDAO;

    public BookController() throws SQLException, ClassNotFoundException {
        this.bookDAO = new BookDAO();
    }

    public boolean adicionarLivro(BookBean book) throws SQLException, ClassNotFoundException {
        return this.bookDAO.create(book);
    }

    public boolean editarLivro(BookBean book) throws SQLException, ClassNotFoundException {
        return this.bookDAO.edit(book);
    }

    public boolean removerLivro(BookBean book) throws SQLException, ClassNotFoundException {
        return this.bookDAO.delete(book);
    }

    public ArrayList<BookBean> buscarLivros() throws SQLException, ClassNotFoundException {
        return this.bookDAO.listAll();
    }
}
