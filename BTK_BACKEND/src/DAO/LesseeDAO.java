package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

import Utils.Conexao;
import Model.LesseeBean;

public class LesseeDAO {

    private final Connection CON;

    public LesseeDAO() throws SQLException, ClassNotFoundException {
        this.CON = new Conexao().getConnection();
    }

    public boolean create(LesseeBean lessee) {
        final String sql = "insert into lessee(nome, dataNasc, telefone, celular, email)values(?,?,?,?,?)";
        try {
            PreparedStatement ps = this.CON.prepareStatement(sql);

            ps.setString(1, lessee.getNome());
            ps.setString(2, lessee.getDataNasc());
            ps.setString(3, lessee.getTelefone());
            ps.setString(4, lessee.getCelular());
            ps.setString(5, lessee.getEmail());

            ps.executeUpdate();
            ps.close();

            return true;

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean edit(LesseeBean lessee) {
        final String sql = "update lessee set nome = ?, dataNasc = ?, telefone = ?, celular = ?, email = ? where id = ?";

        try {
            PreparedStatement ps = this.CON.prepareStatement(sql);

            ps.setString(1, lessee.getNome());
            ps.setString(2, lessee.getDataNasc());
            ps.setString(3, lessee.getTelefone());
            ps.setString(4, lessee.getCelular());
            ps.setString(5, lessee.getEmail());
            ps.setInt(6, lessee.getId());

            ps.executeUpdate();

            ps.close();

            return true;

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean delete(LesseeBean lessee) {
        final String sql = "delete from lessee where id = ?";

        try {
            PreparedStatement ps = this.CON.prepareStatement(sql);

            ps.setInt(1, lessee.getId());

            ps.executeUpdate();
            ps.close();

            return true;

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public ArrayList<LesseeBean> listAll() {
        final String sql = "select * from lessee order by -lessee.id";

        ArrayList<LesseeBean> lesses = new ArrayList<>();
        try {
            PreparedStatement ps = this.CON.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    LesseeBean lb = new LesseeBean(
                            rs.getString("nome"),
                            rs.getString("telefone"),
                            rs.getString("celular"),
                            rs.getString("email"),
                            rs.getString("dataNasc"));

                    lb.setId(rs.getInt("id"));

                    lesses.add(lb);
                }
                ps.close();
                rs.close();
                return lesses;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }

    }

}
