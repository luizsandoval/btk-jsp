package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Utils.Conexao;
import Model.BookBean;

public class BookDAO {

    private final Connection CON;

    public BookDAO() throws SQLException, ClassNotFoundException {
        this.CON = new Conexao().getConnection();
    }

    public boolean create(BookBean book) {
        final String sql = "insert into book(nome, editora, descricao, quantidade, id_AUTOR, id_GENERO) values (?,?,?,?,?,?)";

        try {
            PreparedStatement ps = this.CON.prepareStatement(sql);

            ps.setString(1, book.getNome());
            ps.setString(2, book.getEditora());
            ps.setString(3, book.getDescricao());
            ps.setInt(4, book.getQuantidade());
            ps.setInt(5, this.getAuthorId(book.getAutor()));
            ps.setInt(6, this.getGenderId(book.getGenero()));

            ps.executeUpdate();
            ps.close();

            return true;

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean edit(BookBean book) {
        final String sql = "update book set nome = ?, editora = ?, descricao = ?, quantidade = ?, id_AUTOR = ?, id_GENERO = ? where id = ?";

        try {
            PreparedStatement ps = this.CON.prepareStatement(sql);

            ps.setString(1, book.getNome());
            ps.setString(2, book.getEditora());
            ps.setString(3, book.getDescricao());
            ps.setInt(4, book.getQuantidade());
            ps.setInt(5, this.getAuthorId(book.getAutor()));
            ps.setInt(6, this.getGenderId(book.getGenero()));
            ps.setInt(7, book.getId());

            ps.executeUpdate();
            ps.close();

            return true;

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean delete(BookBean book) {
        final String sql = "delete from book where id = ?";

        try {
            PreparedStatement ps = this.CON.prepareStatement(sql);

            ps.setInt(1, book.getId());

            ps.executeUpdate();
            ps.close();

            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }

    }

    public ArrayList<BookBean> listAll() {
        final String sql = "select book.id, book.nome, book.editora, book.descricao, book.quantidade, genero.nome, autor.nome "
                + " from book as b inner join author as a on b.id_autor = a.id "
                + " inner join gender as g on book.id_genero = g.id order by -book.id";

        ArrayList<BookBean> books = new ArrayList<>();
        try {
            PreparedStatement ps = this.CON.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    BookBean cb = new BookBean(
                            rs.getString("nome"),
                            rs.getString("editora"),
                            rs.getString("descricao"),
                            rs.getString("autor"),
                            rs.getString("genero"),
                            rs.getInt("quantidade")
                    );
                    cb.setId(rs.getInt("id"));

                    books.add(cb);
                }
                ps.close();
                rs.close();
                return books;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }

    }

    private int getAuthorId(String autor) {
        final String sql = "select * from author where nome = ?";
        int autorID = 0;
        try {
            PreparedStatement ps = this.CON.prepareStatement(sql);
            ps.setString(1, autor);

            ResultSet rs = ps.executeQuery();

            autorID = rs.getInt("id");

        } catch (SQLException e) {
            System.out.println(e);
        }
        return autorID;
    }

    private int getGenderId(String genero) {
        int generoID = 0;
        final String sql = "select * from gender where nome = ?";
        try {
            PreparedStatement ps = this.CON.prepareStatement(sql);
            ps.setString(1, genero);

            ResultSet rs = ps.executeQuery();
            rs.first();

            generoID = rs.getInt("id");
            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return generoID;
    }

}
