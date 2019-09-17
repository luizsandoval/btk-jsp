package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Utils.Conexao;
import Model.UserBean;

public class UserDAO {

    private final Connection CON;

    public UserDAO() throws SQLException, ClassNotFoundException {
        this.CON = new Conexao().getConnection();
    }

    public boolean create(UserBean user) {
        final String sql = "insert into user(nome, email, senha) values (?,?,?)";
        try {
            PreparedStatement ps = this.CON.prepareStatement(sql);

            ps.setString(1, user.getNome());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getSenha());

            ps.executeUpdate();
            ps.close();

            return true;

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean edit(UserBean user) {
        final String sql = "update user set nome = ?, email = ?, senha = ? where id = ?";
        try {
            PreparedStatement ps = this.CON.prepareStatement(sql);

            ps.setString(1, user.getNome());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getSenha());
            ps.setInt(4, user.getId());

            ps.executeUpdate();
            ps.close();

            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean delete(UserBean user) {
        final String sql = "delete from user where id = ?";
        try {
            PreparedStatement ps = this.CON.prepareStatement(sql);

            ps.setInt(1, user.getId());

            ps.executeUpdate();
            ps.close();

            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public ArrayList<UserBean> listAll() {
        final String sql = "select * from user order by -user.id";

        ArrayList<UserBean> users = new ArrayList<UserBean>();
        try {
            PreparedStatement ps = this.CON.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs != null) {

                while (rs.next()) {
                    UserBean ub = new UserBean(rs.getString("email"), rs.getString("senha"), rs.getString("nome"));
                    ub.setId(rs.getInt("id"));

                    users.add(ub);
                }
                return users;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public UserBean authenticate(String email, String pwd) {
        final String sql = "select * from user where email = ? AND senha = ?";
        try {
            PreparedStatement ps = this.CON.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, pwd);

            ResultSet rs = ps.executeQuery();
            rs.first();

            if (rs.next()) {
                UserBean ub = new UserBean(rs.getString("email"), "", rs.getString("nome"));
                ub.setId(rs.getInt("id"));
                return ub;
            }
            return null;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public String getUserByEmail(String email) {
        final String sql = "select nome from user where email = ?";
        try {
            PreparedStatement ps = this.CON.prepareStatement(sql);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("nome");
            }
            return "";
        } catch (SQLException e) {
            System.out.println(e);
            return "";
        }
    }

}
