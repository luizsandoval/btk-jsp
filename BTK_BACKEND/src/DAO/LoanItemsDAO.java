package DAO;

import Model.BookBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

import Utils.Conexao;
import Model.LoanItemsBean;

public class LoanItemsDAO {

    final private Connection CON;

    public LoanItemsDAO() throws SQLException, ClassNotFoundException {
        this.CON = new Conexao().getConnection();
    }

    public boolean create(LoanItemsBean items) {
        final String sql = "INSERT INTO loan_items(id_book, quantidade, id_loan) VALUES (?,?,?)";
        try {
            PreparedStatement ps = this.CON.prepareStatement(sql);

            final int bookId = items.getBookId();
            final int qtd = items.getQuantidade();

            this.dicreaseQuantity(bookId, qtd);

            ps.setInt(1, bookId);
            ps.setInt(2, qtd);
            ps.setInt(3, items.getIdEmprestimo());

            ps.executeUpdate();

            ps.close();

            return true;

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }

    }

    public ArrayList<LoanItemsBean> listAllLoanItems() {
        final String sql = "SELECT * FROM loan_items";
        ArrayList<LoanItemsBean> loanItems = new ArrayList<LoanItemsBean>();
        try {
            PreparedStatement ps = this.CON.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    LoanItemsBean lib = new LoanItemsBean(
                            rs.getInt("id_loan"),
                            rs.getInt("id_book"),
                            rs.getInt("quantidade")
                    );
                    lib.setId(rs.getInt("id"));
                }
                ps.close();
                rs.close();
                return loanItems;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public int getItemsTotal(int loanId) {
        final String sql = "SELECT COUNT(id_loan)total FROM loan_items WHERE id_loan = ?";
        int id = 0;
        try {
            PreparedStatement ps = this.CON.prepareStatement(sql);
            ps.setInt(1, loanId);
            
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                id = rs.getInt("total");
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return id;
    }

    private void dicreaseQuantity(int bookId, int qty) {
        qty = this.getBookQuantity(bookId) - qty;

        if (qty > 0) {
            String sql = "UPDATE book SET quantidade = "
                    + String.valueOf(qty)
                    + " WHERE id = "
                    + String.valueOf(bookId);
            try {
                PreparedStatement ps;
                ps = this.CON.prepareStatement(sql);

                ps.executeUpdate();
                ps.close();

            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    private int getBookQuantity(int bookId) {
        final String sql = "SELECT quantidade FROM book WHERE id = ?";
        int qty = 0;
        try {
            PreparedStatement ps = this.CON.prepareStatement(sql);
            ps.setInt(1, bookId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                qty = rs.getInt("quantidade");
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return qty;
    }

    public ArrayList<BookBean> listAddedItems(String title) {
        final String sql = "SELECT book.id, book.nome, author.nome, book.editora, gender.nome "
                + "FROM book AS book INNER JOIN author AS author ON book.id_author = author.id "
                + "INNER JOIN gender AS gender ON book.id_gender = gender.id "
                + "WHERE book.nome LIKE '%" + title + "%'" + " ORDER BY book.id";

        ArrayList<BookBean> adicionarItens = new ArrayList<>();
        try {
            PreparedStatement ps = this.CON.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    BookBean bb = new BookBean(
                            rs.getString("nome"),
                            rs.getString("editora"),
                            rs.getString("descricao"),
                            rs.getString("author"),
                            rs.getString("gender"),
                            rs.getInt("quantidade"));

                    bb.setId(rs.getInt("id"));

                    adicionarItens.add(bb);
                }
                ps.close();
                rs.close();
                return adicionarItens;
            } else {

                return null;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }

    }

    public ArrayList<BookBean> listAllBooks(int id_loan) {
        final String sql = "SELECT book.id, book.nome, author.nome, book.editora, gender.descricao, items.quantidade "
                + "FROM book AS book INNER JOIN author AS author ON book.id_author = author.id "
                + "INNER JOIN gender AS gender ON book.id_gender = gender.id "
                + "INNER JOIN loan_items AS items ON items.id_book = book.id "
                + "INNER JOIN loan AS loan ON items.id_loan = loan.id"
                + "WHERE items.id_loan = " + String.valueOf(id_loan) + " ORDER BY id";

        ArrayList<BookBean> booksList = new ArrayList<>();

        try {
            PreparedStatement ps = this.CON.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    BookBean ob = new BookBean(
                            rs.getString("nome"),
                            rs.getString("editora"),
                            rs.getString("descricao"),
                            rs.getString("author"),
                            rs.getString("gender"),
                            rs.getInt("quantidade")
                    );

                    ob.setId(rs.getInt("id"));

                    booksList.add(ob);
                }
                ps.close();
                rs.close();
                return booksList;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
}
