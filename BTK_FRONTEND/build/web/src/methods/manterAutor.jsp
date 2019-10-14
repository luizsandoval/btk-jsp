<%@page import="Controller.AuthorController"%>
<%@page import="Model.AuthorBean"%>
<%
    final AuthorBean ab = new AuthorBean(
            request.getParameter("NOME"),
            request.getParameter("SEXO"),
            request.getParameter("NACIONALIDADE"),
            request.getParameter("IDADE"));

    final AuthorController ac = new AuthorController();

    if (request.getParameter("ID") != null) {

        ab.setId(Integer.parseInt(request.getParameter("ID")));

        if (request.getParameter("DELETE") != null) {
            ac.removerAutor(ab);
        } else {
            ac.editarAutor(ab);
        }
    } else {
        ac.adicionarAutor(ab);
    }

    response.sendRedirect("../pages/manageAuthors.jsp");
%>