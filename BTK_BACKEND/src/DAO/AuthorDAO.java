package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Utils.Conexao;
import Model.AuthorBean;

public class AuthorDAO {

    private final Connection CON;

    public AuthorDAO() throws SQLException, ClassNotFoundException {
        this.CON = new Conexao().getConnection();
    }

    public boolean create(AuthorBean author) {
        final String sql = "insert into author(nome, sexo, nacionalidade, idade) value (?, ?, ?, ?)";
        try {
            PreparedStatement ps = this.CON.prepareStatement(sql);
            
            ps.setString(1, author.getNome());
            ps.setString(2, author.getSexo());
            ps.setString(3, author.getNacionalidade());
            ps.setString(4, author.getIdade());

            ps.executeUpdate();
            ps.close();
            
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean edit(AuthorBean author) {
        final String sql = "update author set nome = ?, sexo = ?, nacionalidade = ?, idade = ? where id = ?";
        try {
            PreparedStatement ps = this.CON.prepareStatement(sql);

            ps.setString(1, author.getNome());
            ps.setString(2, author.getSexo());
            ps.setString(3, author.getNacionalidade());
            ps.setString(4, author.getIdade());
            ps.setInt(5, author.getId());

            if (ps.executeUpdate() == 0) {
                ps.close();
                return true;
            } else {
                ps.close();
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }

    }

    public boolean delete(AuthorBean author) {
        final String sql = "delete from author where id = ?";

        try {
            PreparedStatement ps = this.CON.prepareStatement(sql);
            ps.setInt(1, author.getId());

            if (ps.executeUpdate() == 0) {
                ps.close();
                return true;
            } else {
                ps.close();
                return false;
            }

        } catch (SQLException e) {

            System.out.println(e);
            return false;
        }
    }

    public ArrayList<AuthorBean> listAll() {
        final String sql = "select * from author";

        ArrayList<AuthorBean> authors = new ArrayList<AuthorBean>();

        try {
            PreparedStatement ps = this.CON.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    AuthorBean ub = new AuthorBean(rs.getString("nome"), rs.getString("sexo"), rs.getString("nacionalidade"), rs.getString("idade"));
                    ub.setId(rs.getInt("id"));
                    authors.add(ub);
                }
                rs.close();
                ps.close();
                return authors;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }

    }

}
