
<%@page import="java.util.List"%>

<%@page import="Controller.LoanController"%>
<%@page import="Controller.UserController"%>
<%@page import="Controller.BookController"%>

<%@page import="Model.BookBean"%>
<%@page import="Model.LoanBean"%>

<%
    LoanBean lb = new LoanBean(0, 0, 0);

    final List<BookBean> books = new BookController().buscarLivros();
    final List<UserBean> users = new UserController().buscarUsuarios();

    if (request.getParameter("ID") != null) {
        lb.setId(Integer.parseInt(request.getParameter("ID")));
        lb = new LoanController().buscarEmprestimoPorId(lb);
    }
%>
<html>
    <head>
        <%@include file="../../src/core/meta.jsp" %>
        <title>BTK - Sistema Bibliotecário | Manter Empréstimo</title>
        <%@include file="../../src/core/head.jsp" %>
    </head>
    <body>
        <%@include file="../../src/core/header.jsp" %>
        <div class="container-fluid p-5">
            <form action="../methods/manterEmprestimo.jsp<%= request.getParameter("ID") != null ? "?ID=" + lb.getId() : ""%>" method="post">
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                        <div class="d-flex align-items-center justify-content-between form-header">
                            <h4 class="modal-title mb-3">Manter Empréstimo</h4>
                            <span class="text-muted modal-subtitle mb-3">
                                <%= request.getParameter("ID") != null ? "Devolver" : "Emprestar"%>
                            </span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                        <div class="form-group">
                            <label for="LIVRO">Livro*</label>
                            <select name="LIVRO" class="form-control" required>
                                <option value="" <%= lb.getIdLivro() == 0 ? "selected" : ""%>>Selecione um Livro...</option>
                                <% for (BookBean book : books) {%>
                                    <option value="<%= book.getId()%>" <%= book.getId() == lb.getIdLivro() ? "selected" : ""%>><%= book.getNome()%></option>
                                <% }%>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                        <div class="form-group">
                            <label for="LOCATARIO">Locatário*</label>
                            <select name="LOCATARIO" class="form-control" required>
                                <option value="" <%= lb.getIdLocatario() == 0 ? "selected" : ""%>>Selecione um Locatário...</option>
                                <% for (UserBean user : users) {%>
                                <option value="<%= user.getId()%>" <%= user.getId() == lb.getIdLocatario() ? "selected" : ""%>><%= user.getNome()%></option>
                                <% }%>
                            </select>
                        </div>

                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                        <div class="d-flex justify-content-end align-items-center">
                            <a class="btn btn-link" href="./main.jsp" >Voltar</a>
                            <button type="submit" class="btn btn-primary"><%= request.getParameter("ID") != null ? "Devolver" : "Emprestar"%></button>
                        </div>
                    </div>
                </div>
            </form>

        </div>
        <%@include file="../../src/core/footer.jsp" %>
    </body>
</html>