<%@page import="Controller.BookController"%>
<%@page import="Model.BookBean"%>
<%
    final BookBean bb = new BookBean(
            request.getParameter("NOME"),
            request.getParameter("EDITORA"),
            request.getParameter("DESCRICAO"),
            request.getParameter("AUTOR"),
            request.getParameter("GENERO"),
            Integer.parseInt(request.getParameter("QUANTIDADE")));

    final BookController bc = new BookController();

    if (request.getParameter("ID") != null) {
        System.out.print(request.getParameter("ID"));
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