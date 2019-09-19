<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("user") != null) {
        response.sendRedirect("./src/pages/main.jsp");
    } else {
        response.sendRedirect("./src/pages/login.jsp");
    }
%>