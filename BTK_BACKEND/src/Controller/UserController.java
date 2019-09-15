package Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.UserDAO;
import Model.UserBean;

public class UserController {

    final private UserDAO userDAO;

    public UserController() throws SQLException, ClassNotFoundException {
        this.userDAO = new UserDAO();
    }

    public String buscarUsuarioPorEmail(UserBean user) throws SQLException, ClassNotFoundException {
        return this.userDAO.getUserByEmail(user.getEmail());
    }

    public boolean fazerLogin(UserBean user) throws SQLException, ClassNotFoundException {
        return this.userDAO.authenticate(user.getEmail(), user.getSenha());
    }

    public boolean adicionarUsuario(UserBean user) throws SQLException, ClassNotFoundException {
        return this.userDAO.create(user);
    }

    public boolean editarUsuario(UserBean user) throws SQLException, ClassNotFoundException {
        return this.userDAO.edit(user);
    }

    public boolean removerUsuario(UserBean user) throws SQLException, ClassNotFoundException {
        return this.userDAO.delete(user);
    }

    public ArrayList<UserBean> buscarUsuarios() throws SQLException, ClassNotFoundException {
        return this.userDAO.listAll();
    }
}
