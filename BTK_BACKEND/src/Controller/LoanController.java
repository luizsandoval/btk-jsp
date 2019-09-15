package Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.LoanDAO;
import Model.LoanBean;

public class LoanController {

    final private LoanDAO loanDAO;

    public LoanController() throws SQLException, ClassNotFoundException {
        this.loanDAO = new LoanDAO();
    }

    public boolean realizarEmprestimo(LoanBean loan) throws SQLException, ClassNotFoundException {
        return this.loanDAO.lend(loan);
    }

    public boolean realizarDevolucao(LoanBean loan) throws SQLException, ClassNotFoundException {
        return this.loanDAO.returnBook(loan);
    }

    public ArrayList<LoanBean> buscarEmprestimosEmAberto() throws SQLException, ClassNotFoundException {
        return this.loanDAO.listAll();
    }
}
