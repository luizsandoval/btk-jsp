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
        final String sql = "INSERT INTO book(nome, editora, descricao, quantidade, id_author, id_gender) VALUES (?,?,?,?,?,?)";

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
        final String sql = "UPDATE book SET nome = ?, editora = ?, descricao = ?, quantidade = ?, id_author = ?, id_gender = ? WHERE id = ?";

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
        final String sql = "DELETE FROM book WHERE id = ?";

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

    public BookBean getBookById(int id) {
        final String sql = "SELECT b.id, b.nome, b.editora, b.descricao, b.quantidade, g.nome AS genero, a.nome AS autor "
                + " FROM book AS b INNER JOIN author AS a ON b.id_author = a.id "
                + " INNER JOIN gender AS g ON b.id_gender = g.id WHERE b.id = ?";
        try {
            PreparedStatement ps = this.CON.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                BookBean bb = new BookBean(
                        rs.getString("nome"),
                        rs.getString("editora"),
                        rs.getString("descricao"),
                        rs.getString("autor"),
                        rs.getString("genero"),
                        rs.getInt("quantidade")
                );
                bb.setId(rs.getInt("id"));
                ps.close();
                rs.close();
                return bb;
            }
            ps.close();
            rs.close();
            return null;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public ArrayList<BookBean> listAll() {
        final String sql = "SELECT b.id, b.nome, b.editora, b.descricao, b.quantidade, g.nome AS genero, a.nome AS autor "
                + " FROM book AS b INNER JOIN author AS a ON b.id_author = a.id "
                + " INNER JOIN gender AS g ON b.id_gender = g.id ORDER BY -b.id";

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
        final String sql = "SELECT id FROM author WHERE nome = ?";
        int autorID = 0;
        try {
            PreparedStatement ps = this.CON.prepareStatement(sql);
            ps.setString(1, autor);

            ResultSet rs = ps.executeQuery();
            rs.first();

            autorID = rs.getInt("id");

        } catch (SQLException e) {
            System.out.println(e);
        }
        return autorID;
    }

    private int getGenderId(String genero) {
        int generoID = 0;
        final String sql = "SELECT id FROM gender WHERE nome = ?";
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
