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
        final String sql = "INSERT INTO loan(id_user, id_lessee, status = 'Em Aberto', dataEmprestimo, dataDevolucao) VALUES(?,?,,?,?)";
        try {
            PreparedStatement ps = this.CON.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, this.getIdByName("user", loan.getUsuario()));
            ps.setInt(2, this.getIdByName("lessee", loan.getLocatario()));
            ps.setString(3, loan.getDataEmprestimo());
            ps.setString(4, loan.getDataDevolucao());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                loan.setId(rs.getInt(1));
            }
            ps.close();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean returnBook(LoanBean loan) {
        final String sql = "UPDATE loan SET dataDevolucaoReal = ?, loanStatus = 'Finalizado' WHERE id = ?";

        try {
            PreparedStatement ps = this.CON.prepareStatement(sql);

            ps.setString(1, loan.getDataDevolucaoReal());
            ps.setInt(2, loan.getId());

            ps.executeUpdate();
            ps.close();

            return true;

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    private int getIdByName(String tableName, String value) {
        final String sql = "SELECT id FROM " + tableName + " WHERE nome = ?";
        int id = 0;
        try {
            PreparedStatement ps = this.CON.prepareStatement(sql);
            ps.setString(1, value);

            ResultSet rs = ps.executeQuery();
            rs.first();

            id = rs.getInt("id");

            ps.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return id;
    }

    public ArrayList<LoanBean> listAll() {
        final String sql = "SELECT loan.id, user.nome, lessee.nome, "
                + " loan.dataEmprestimo, loan.dataDevolucao, loan.status"
                + " FROM loan AS loan INNER JOIN user AS user "
                + " ON loan.id_user = user.id INNER JOIN lessee AS lessee "
                + " ON loan.id_lessee = lessee.id WHERE "
                + " loan.status ='Em Aberto' ORDER BY loan.id";

        ArrayList<LoanBean> loans = new ArrayList<>();
        try {

            PreparedStatement ps = this.CON.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    LoanBean eb = new LoanBean(
                            rs.getString("user"),
                            rs.getString("lessee"),
                            rs.getString("status"),
                            rs.getString("dataEmprestimo"),
                            rs.getString("dataDevolucao"),
                            rs.getString("dataDevolucaoReal")
                    );
                    eb.setId(rs.getInt("id"));

                    loans.add(eb);
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

}
