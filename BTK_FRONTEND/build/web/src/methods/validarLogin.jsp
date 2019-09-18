<%--<%@page import="javax.swing.JOptionPane"%>--%>
<%@page import="Controller.UserController"%>
<%@page import="Model.UserBean"%>
<%
    final String email = request.getParameter("EMAIL");
    final String senha = request.getParameter("SENHA");
    UserBean ub = new UserBean(email, senha);
    final UserController uc = new UserController();

    ub = uc.fazerLogin(ub);
    
    if (ub != null) {
        session.setAttribute("loggedUser", ub);
        
        response.sendRedirect("../pages/main.jsp");
    } else {
        response.sendRedirect("../pages/login.jsp");
    }
%>