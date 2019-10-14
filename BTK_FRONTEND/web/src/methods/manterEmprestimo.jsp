<%@page import="Model.UserBean"%>
<%@page import="Model.LoanBean"%>
<%@page import="Controller.LoanController"%>

<%
    final LoanBean lb = new LoanBean(
            ((UserBean) session.getAttribute("loggedUser")).getId(),
            Integer.parseInt(request.getParameter("LOCATARIO")),
            Integer.parseInt(request.getParameter("LIVRO"))
    );

    lb.setIdLivro(Integer.parseInt(request.getParameter("LIVRO")));

    final LoanController lc = new LoanController();

    if (request.getParameter("ID") != null) {

        lb.setId(Integer.parseInt(request.getParameter("ID")));

        lc.realizarDevolucao(lb);
    } else {
        lc.realizarEmprestimo(lb);
    }

    response.sendRedirect("../pages/main.jsp");

%>