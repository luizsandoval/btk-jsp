package Controller;

import java.sql.SQLException;
import java.util.List;

import DAO.LesseeDAO;
import Model.LesseeBean;

public class LesseeController {

    final private LesseeDAO lesseeDAO;

    public LesseeController() throws SQLException, ClassNotFoundException {
        this.lesseeDAO = new LesseeDAO();
    }

    public boolean adicionarLocatario(LesseeBean lessee) throws SQLException, ClassNotFoundException {
        return this.lesseeDAO.create(lessee);
    }

    public boolean editarLocatario(LesseeBean lessee) throws SQLException, ClassNotFoundException {
        return this.lesseeDAO.edit(lessee);
    }

    public boolean removerLocatario(LesseeBean lessee) throws SQLException, ClassNotFoundException {
        return this.lesseeDAO.delete(lessee);
    }

    public List<LesseeBean> buscarLocatarios() throws SQLException, ClassNotFoundException {
        return this.lesseeDAO.listAll();
    }

}
