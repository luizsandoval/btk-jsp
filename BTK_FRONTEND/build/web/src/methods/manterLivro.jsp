<%@page import="Controller.BookController"%>
<%@page import="Model.BookBean"%>
<%
    final int qtd = request.getParameter("QUANTIDADE") != null ? Integer.parseInt(request.getParameter("QUANTIDADE")) : 0;
    final BookBean bb = new BookBean(
            request.getParameter("NOME"),
            request.getParameter("EDITORA"),
            request.getParameter("DESCRICAO"),
            request.getParameter("AUTOR"),
            request.getParameter("GENERO"),
            qtd);

    final BookController bc = new BookController();

    if (request.getParameter("ID") != null) {

        bb.setId(Integer.parseInt(request.getParameter("ID")));

        if (request.getParameter("ACTION").equals("DELETE")) {
            bc.removerLivro(bb);
        } else {
            bc.editarLivro(bb);
        }
    } else {
        bc.adicionarLivro(bb);
    }

    response.sendRedirect("../pages/manageBooks.jsp");
%>