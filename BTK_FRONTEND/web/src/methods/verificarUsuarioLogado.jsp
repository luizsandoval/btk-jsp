<%
    if (session.getAttribute("loggedUser") == null) {
        response.sendRedirect("./login.jsp");
    }
%>