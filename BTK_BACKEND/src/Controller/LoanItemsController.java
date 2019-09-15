package Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.LoanItemsDAO;
import Model.BookBean;
import Model.LoanItemsBean;

public class LoanItemsController {

    final private LoanItemsDAO loanItemsDAO;

    public LoanItemsController() throws SQLException, ClassNotFoundException {
        this.loanItemsDAO = new LoanItemsDAO();
    }

    public boolean adicionarItem(LoanItemsBean loanItems) throws SQLException, ClassNotFoundException {
        return this.loanItemsDAO.create(loanItems);
    }

    public ArrayList<BookBean> buscarItensDoEmprestimo(LoanItemsBean loanItems) throws SQLException, ClassNotFoundException {
        return this.loanItemsDAO.listAllBooks(loanItems.getId());
    }
    
    public int buscarTotalDeItensNoEmprestimo(LoanItemsBean loan) throws SQLException, ClassNotFoundException {
        return this.loanItemsDAO.getItemsTotal(loan.getId());
    }

    public ArrayList<BookBean> adicionarLinhaNaTabela(BookBean book) throws SQLException, ClassNotFoundException {
        return this.loanItemsDAO.listAddedItems(book.getNome());
    }

    public ArrayList<LoanItemsBean> buscarTodosOsItensDeEmprestimos() throws SQLException, ClassNotFoundException {
        return this.loanItemsDAO.listAllLoanItems();
    }
}
