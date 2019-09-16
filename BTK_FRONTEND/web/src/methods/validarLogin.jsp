<%@page import="javax.swing.JOptionPane"%>
<%@page import="Controller.UserController"%>
<%@page import="Model.UserBean"%>
<%
    final String email = request.getParameter("EMAIL");
    final String senha = request.getParameter("SENHA");
    UserBean ub = new UserBean(email, senha);
    final UserController uc = new UserController();

    ub = uc.fazerLogin(ub);
    
    System.out.print(ub.getNome());
    if (ub != null) {
        System.out.print("objeto: " + ub.toString());
        System.out.print("entrei");
        session.setAttribute("userId", ub.getId());
        session.setAttribute("username", ub.getNome());
        session.setAttribute("userEmail", ub.getEmail());
        
        response.sendRedirect("../pages/main.jsp");
    } else {
        JOptionPane.showMessageDialog(null, "Usuário ou Senha Inválido(s)!");
        response.sendRedirect("../pages/login.jsp");
    }
%>