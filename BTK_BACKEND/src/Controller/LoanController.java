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
        System.out.println("cheguei");
        return this.loanDAO.lend(loan);
    }

    public boolean realizarDevolucao(LoanBean loan) throws SQLException, ClassNotFoundException {
        return this.loanDAO.closeLoan(loan);
    }

    public LoanBean buscarEmprestimoPorId(LoanBean loan) throws SQLException, ClassNotFoundException {
        return this.loanDAO.getLoanById(loan.getId());
    }

    public ArrayList<LoanBean> buscarEmprestimosEmAberto() throws SQLException, ClassNotFoundException {
        return this.loanDAO.listOpenLoans();
    }

    public ArrayList<LoanBean> buscarTodosOsEmprestimos() throws SQLException, ClassNotFoundException {
        return this.loanDAO.listAllLoans();
    }

    public ArrayList<LoanBean> buscarEmprestimosAtrasados() throws SQLException, ClassNotFoundException {
        return this.loanDAO.listLateLoans();
    }
    
    public ArrayList<LoanBean> buscarEmprestimosFinalizados() throws SQLException, ClassNotFoundException {
        return this.loanDAO.listClosedLoans();
    }

    public int buscarQuantidadeDeEmprestimos() throws SQLException, ClassNotFoundException {
        return this.loanDAO.getLoansQuantity();
    }

    public int buscarQuantidadeDeEmprestimosEmAberto() throws SQLException, ClassNotFoundException {
        return this.loanDAO.getOpenLoansQuantity();
    }

    public int buscarQuantidadeDeEmprestimosAtrasados() throws SQLException, ClassNotFoundException {
        return this.loanDAO.getLateLoansQuantity();
    }

    public int buscarQuantidadeDeEmprestimosFinalizados() throws SQLException, ClassNotFoundException {
        return this.loanDAO.getClosedLoansQuantity();
    }

}
