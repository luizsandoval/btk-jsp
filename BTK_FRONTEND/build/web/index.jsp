<%
    if (session.getAttribute("user") != null) {
        response.sendRedirect("./src/pages/main.jsp");
    } else {
        response.sendRedirect("./src/pages/login.jsp");
    }
%>