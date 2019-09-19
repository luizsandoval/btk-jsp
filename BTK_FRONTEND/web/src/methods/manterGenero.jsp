<%@page import="Controller.GenderController"%>
<%@page import="Model.GenderBean"%>
<%@include file="../methods/verificarUsuarioLogado.jsp" %>
<%
    final GenderBean gb = new GenderBean(
            request.getParameter("NOME"),
            request.getParameter("DESCRICAO"));

    final GenderController gc = new GenderController();

    if (request.getParameter("ID") != null) {

        gb.setId(Integer.parseInt(request.getParameter("ID")));

        if (request.getParameter("ACTION").equals("DELETE")) {
            gc.removerGenero(gb);
        } else {
            gc.editarGenero(gb);
        }
    } else {
        gc.adicionarGenero(gb);
    }

    response.sendRedirect("../pages/manageGenders.jsp");
%>