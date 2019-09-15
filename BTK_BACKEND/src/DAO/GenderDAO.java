package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import Model.GenderBean;
import Utils.Conexao;

public class GenderDAO {

    private final Connection CON;

    public GenderDAO() throws SQLException, ClassNotFoundException {
        this.CON = new Conexao().getConnection();
    }

    public boolean create(GenderBean gender) {
        final String sql = "insert into gender(nome, descricao) values(?, ?)";
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
        final String sql = "update gender set nome = ?, descricao = ? where id = ?";
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
        final String sql = "delete from gender where id = ?";
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

    public List<GenderBean> listAll() {
        final String sql = "select * from gender order by -gender.id";

        List<GenderBean> genders = new ArrayList<GenderBean>();
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
