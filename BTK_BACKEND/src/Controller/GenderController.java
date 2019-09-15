package Controller;

import java.sql.SQLException;
import java.util.List;

import DAO.GenderDAO;
import Model.GenderBean;

public class GenderController {

    final private GenderDAO genderDAO;

    public GenderController() throws SQLException, ClassNotFoundException {
        this.genderDAO = new GenderDAO();
    }

    public boolean adicionarGenero(GenderBean gender) throws SQLException, ClassNotFoundException {
        return this.genderDAO.create(gender);
    }

    public boolean editarGenero(GenderBean gender) throws SQLException, ClassNotFoundException {
        return this.genderDAO.edit(gender);
    }

    public boolean removerGenero(GenderBean gender) throws SQLException, ClassNotFoundException {
        return this.genderDAO.delete(gender);
    }

    public List<GenderBean> buscarGeneros() throws SQLException, ClassNotFoundException {
        return this.genderDAO.listAll();
    }
}
