<%@page import="javax.swing.JOptionPane"%>
<%@page import="Controller.UserController"%>
<%@page import="Model.UserBean"%>
<%
    UserBean ub = new UserBean(request.getParameter("EMAIL"), request.getParameter("SENHA"), request.getParameter("NOME"));
    UserController uc = new UserController();

    if (uc.adicionarUsuario(ub)) {
        response.sendRedirect("../pages/login.jsp");
    } else {
        JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar salvar seu Usuário", "Erro", 1);
    }

%>