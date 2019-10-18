<%@page import="Model.UserBean"%>
<%@page import="Model.LoanBean"%>
<%@page import="Controller.LoanController"%>

<%

    final int locatario = request.getParameter("LOCATARIO") != null ? Integer.parseInt(request.getParameter("LOCATARIO")) : 0;
    final int livro = request.getParameter("LIVRO") != null ? Integer.parseInt(request.getParameter("LIVRO")) : 0;

    final LoanBean lb = new LoanBean(
            ((UserBean) session.getAttribute("loggedUser")).getId(),
            locatario,
            livro
    );

    lb.setIdLivro(livro);

    final LoanController lc = new LoanController();

    if (request.getParameter("ID") != null) {

        lb.setId(Integer.parseInt(request.getParameter("ID")));

        lc.realizarDevolucao(lb);
    } else {
        lc.realizarEmprestimo(lb);
    }

    response.sendRedirect("../pages/main.jsp");

%>