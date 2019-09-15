package Model;

public class LoanItemsBean {

    private int id;
    private int idEmprestimo;
    private int bookId;
    private int quantidade;

    public LoanItemsBean(int idEmprestimo, int bookId, int quantidade) {
        this.idEmprestimo = idEmprestimo;
        this.bookId = bookId;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
