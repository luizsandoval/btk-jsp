package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

import Utils.Conexao;
import Model.LoanBean;

public class LoanDAO {

    private final Connection CON;

    public LoanDAO() throws SQLException, ClassNotFoundException {
        this.CON = new Conexao().getConnection();
    }

    public boolean lend(LoanBean loan) {
        final String sql = "INSERT INTO loan"
                + "(id_user, id_lessee, id_book, loanStatus, dataEmprestimo, dataDevolucao)"
                + " VALUES(?,?,?,'Em Aberto',DATE(NOW()), DATE_ADD(DATE(NOW()), INTERVAL 7 DAY))";
        try {
            final PreparedStatement ps = this.CON.prepareStatement(sql);

            ps.setInt(1, loan.getIdUsuario());
            ps.setInt(2, loan.getIdLocatario());
            ps.setInt(3, loan.getIdLivro());

            ps.executeUpdate();

            ps.close();

            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public LoanBean getLoanById(int id) {
        final String sql = "SELECT * FROM loan WHERE id = ?";

        try {
            final PreparedStatement ps = this.CON.prepareStatement(sql);

            ps.setInt(1, id);

            final ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                final LoanBean lb = new LoanBean(
                        rs.getInt("id_user"),
                        rs.getInt("id_lessee"),
                        rs.getInt("id_book")
                );
                lb.setStatus(rs.getString("loanStatus"));
                lb.setDataDevolucao(rs.getDate("dataDevolucao"));
                lb.setId(rs.getInt("id"));
                ps.close();
                rs.close();
                return lb;
            }
            ps.close();
            rs.close();
            return null;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }

    }

    public boolean closeLoan(LoanBean loan) {
        final String sql = "UPDATE loan SET dataDevolucaoReal = DATE(NOW()), loanStatus = 'Finalizado' WHERE id = ?";

        try {
            final PreparedStatement ps = this.CON.prepareStatement(sql);

            ps.setInt(1, loan.getId());

            ps.executeUpdate();
            ps.close();

            return true;

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public ArrayList<LoanBean> listAllLoans() {
        final String sql = "SELECT loan.id, user.nome AS user, lessee.nome AS lessee, book.nome AS book,"
                + " loan.dataEmprestimo, loan.dataDevolucao, loan.dataDevolucaoReal, loan.loanStatus"
                + " FROM loan AS loan"
                + " INNER JOIN user AS user"
                + " ON loan.id_user = user.id"
                + " INNER JOIN lessee AS lessee"
                + " ON loan.id_lessee = lessee.id"
                + " INNER JOIN book AS book"
                + " ON loan.id_book = book.id"
                + " ORDER BY loan.id";

        final ArrayList<LoanBean> loans = new ArrayList<LoanBean>();
        try {

            PreparedStatement ps = this.CON.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    LoanBean lb = new LoanBean(0, 0, 0);
                    lb.setId(rs.getInt("id"));
                    lb.setNomeUsuario(rs.getString("user"));
                    lb.setNomeLocatario(rs.getString("lessee"));
                    lb.setNomeLivro(rs.getString("book"));
                    lb.setStatus(rs.getString("loanStatus"));
                    lb.setDataEmprestimo(rs.getDate("dataEmprestimo"));
                    lb.setDataDevolucao(rs.getDate("dataDevolucao"));
                    lb.setDataDevolucao(rs.getDate("dataDevolucaoReal"));

                    loans.add(lb);
                }
                ps.close();
                rs.close();
                return loans;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public ArrayList<LoanBean> listOpenLoans() {
        final String sql = "SELECT loan.id, user.nome AS user, lessee.nome AS lessee, book.nome AS book,"
                + " loan.dataEmprestimo, loan.dataDevolucao, loan.loanStatus"
                + " FROM loan AS loan"
                + " INNER JOIN user AS user"
                + " ON loan.id_user = user.id"
                + " INNER JOIN lessee AS lessee"
                + " ON loan.id_lessee = lessee.id"
                + " INNER JOIN book AS book"
                + " ON loan.id_book = book.id"
                + " WHERE loan.loanStatus = 'Em Aberto'"
                + " ORDER BY loan.id";

        final ArrayList<LoanBean> loans = new ArrayList<LoanBean>();
        try {

            PreparedStatement ps = this.CON.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    LoanBean lb = new LoanBean(0, 0, 0);
                    lb.setId(rs.getInt("id"));
                    lb.setNomeUsuario(rs.getString("user"));
                    lb.setNomeLocatario(rs.getString("lessee"));
                    lb.setNomeLivro(rs.getString("book"));
                    lb.setStatus(rs.getString("loanStatus"));
                    lb.setDataEmprestimo(rs.getDate("dataEmprestimo"));
                    lb.setDataDevolucao(rs.getDate("dataDevolucao"));

                    loans.add(lb);
                }
                ps.close();
                rs.close();
                return loans;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public ArrayList<LoanBean> listLateLoans() {
        final String sql = "SELECT loan.id, user.nome AS user, lessee.nome AS lessee, book.nome AS book,"
                + " loan.dataEmprestimo, loan.dataDevolucao, loan.loanStatus"
                + " FROM loan AS loan "
                + " INNER JOIN user AS user"
                + " ON loan.id_user = user.id"
                + " INNER JOIN lessee AS lessee"
                + " ON loan.id_lessee = lessee.id"
                + " INNER JOIN book AS book"
                + " ON loan.id_book = book.id"
                + " WHERE DATEDIFF(loan.dataDevolucao, DATE(NOW())) < 0"
                + " ORDER BY loan.id";

        final ArrayList<LoanBean> loans = new ArrayList<LoanBean>();
        try {

            PreparedStatement ps = this.CON.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    LoanBean lb = new LoanBean(0, 0, 0);
                    lb.setId(rs.getInt("id"));
                    lb.setNomeUsuario(rs.getString("user"));
                    lb.setNomeLocatario(rs.getString("lessee"));
                    lb.setNomeLivro(rs.getString("book"));
                    lb.setStatus(rs.getString("loanStatus"));
                    lb.setDataEmprestimo(rs.getDate("dataEmprestimo"));
                    lb.setDataDevolucao(rs.getDate("dataDevolucao"));

                    loans.add(lb);
                }
                ps.close();
                rs.close();
                return loans;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public ArrayList<LoanBean> listClosedLoans() {
        final String sql = "SELECT loan.id, user.nome AS user, lessee.nome AS lessee, book.nome AS book,"
                + " loan.dataEmprestimo, loan.dataDevolucao, loan.dataDevolucaoReal, loan.loanStatus"
                + " FROM loan AS loan"
                + " INNER JOIN user AS user"
                + " ON loan.id_user = user.id"
                + " INNER JOIN lessee AS lessee"
                + " ON loan.id_lessee = lessee.id"
                + " INNER JOIN book AS book"
                + " ON loan.id_book = book.id"
                + " WHERE loan.loanStatus = 'Finalizado'"
                + " ORDER BY loan.id";

        final ArrayList<LoanBean> loans = new ArrayList<LoanBean>();
        try {

            PreparedStatement ps = this.CON.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    LoanBean lb = new LoanBean(0, 0, 0);
                    lb.setId(rs.getInt("id"));
                    lb.setNomeUsuario(rs.getString("user"));
                    lb.setNomeLocatario(rs.getString("lessee"));
                    lb.setNomeLivro(rs.getString("book"));
                    lb.setStatus(rs.getString("loanStatus"));
                    lb.setDataEmprestimo(rs.getDate("dataEmprestimo"));
                    lb.setDataDevolucao(rs.getDate("dataDevolucao"));
                    lb.setDataDevolucaoReal(rs.getDate("dataDevolucaoReal"));

                    loans.add(lb);
                }
                ps.close();
                rs.close();
                return loans;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public int getLoansQuantity() {
        final String sql = "SELECT COUNT(*) 'loans' FROM loan";

        try {
            PreparedStatement ps = this.CON.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            int qtd = 0;

            if (rs.next()) {

                qtd = rs.getInt("loans");
            }
            return qtd;

        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }

    }

    public int getOpenLoansQuantity() {
        final String sql = "SELECT COUNT(IF(loanStatus = 'Em Aberto', 1, NULL)) 'openLoans' FROM loan";

        try {
            PreparedStatement ps = this.CON.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            int qtd = 0;

            if (rs.next()) {

                qtd = rs.getInt("openLoans");
            }
            return qtd;

        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }

    }

    public int getLateLoansQuantity() {
        final String sql = "SELECT COUNT(IF(DATEDIFF(dataDevolucao, DATE(NOW())) < 0, 1, NULL)) 'lateLoans' FROM loan";

        try {
            PreparedStatement ps = this.CON.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            int qtd = 0;

            if (rs.next()) {

                qtd = rs.getInt("lateLoans");
            }
            return qtd;

        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }

    }

    public int getClosedLoansQuantity() {
        final String sql = "SELECT COUNT(IF(loanStatus = 'Finalizado', 1, NULL)) 'closedLoans' FROM loan";

        try {
            PreparedStatement ps = this.CON.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            int qtd = 0;

            if (rs.next()) {

                qtd = rs.getInt("closedLoans");
            }
            return qtd;
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }

    }

}
