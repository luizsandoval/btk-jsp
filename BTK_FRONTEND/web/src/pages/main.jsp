<% 
    if (session.getAttribute("userId") == null) {
        response.sendRedirect("./login.jsp");
    }
    
%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="../../src/core/meta.jsp" %>
        <title>BTK - Home</title>
        <%@include file="../../src/core/head.jsp" %>
    </head>
    <body>
        <%@include file="../../src/core/header.jsp" %>
        <div class="container d-flex justify-content-center align-items-center flex-direction-column">

        </div>
        <%@include file="../../src/core/footer.jsp" %>
    </body>
</html>
