package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Utils.Conexao;
import Model.GenderBean;

public class GenderDAO {

    private final Connection CON;

    public GenderDAO() throws SQLException, ClassNotFoundException {
        this.CON = new Conexao().getConnection();
    }

    public boolean create(GenderBean gender) {
        final String sql = "INSERT INTO gender(nome, descricao) VALUES(?, ?)";
        try {
            PreparedStatement ps = this.CON.prepareStatement(sql);

            ps.setString(1, gender.getNome());
            ps.setString(2, gender.getDescricao());

            ps.executeUpdate();
            ps.close();

            return true;

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean edit(GenderBean gender) {
        final String sql = "UPDATE gender SET nome = ?, descricao = ? WHERE id = ?";
        try {
            PreparedStatement ps = this.CON.prepareStatement(sql);
            ps.setString(1, gender.getNome());
            ps.setString(2, gender.getDescricao());
            ps.setInt(3, gender.getId());

            ps.executeUpdate();
            ps.close();

            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }

    }

    public boolean delete(GenderBean gender) {
        final String sql = "DELETE FROM gender WHERE id = ?";
        try {
            PreparedStatement ps = this.CON.prepareStatement(sql);

            ps.setInt(1, gender.getId());

            ps.executeUpdate();
            ps.close();

            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public GenderBean getGenderByID(int id) {
        final String sql = "SELECT * FROM gender WHERE id = ?";
        try {
            PreparedStatement ps = this.CON.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                GenderBean gb = new GenderBean(
                        rs.getString("nome"),
                        rs.getString("descricao")
                );
                gb.setId(rs.getInt("id"));
                ps.close();
                rs.close();
                return gb;
            }
            ps.close();
            rs.close();
            return null;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public ArrayList<GenderBean> listAll() {
        final String sql = "SELECT * FROM gender ORDER BY -gender.id";

        ArrayList<GenderBean> genders = new ArrayList<GenderBean>();
        try {
            PreparedStatement ps = this.CON.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    GenderBean ub = new GenderBean(rs.getString("nome"), rs.getString("descricao"));
                    ub.setId(rs.getInt("id"));
                    genders.add(ub);
                }
                return genders;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }

    }

}
