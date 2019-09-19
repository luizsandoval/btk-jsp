<%@page import="java.util.List"%>
<%@page import="Model.AuthorBean"%>
<%@page import="Controller.AuthorController"%>
<%@include file="../methods/verificarUsuarioLogado.jsp" %>

<%
    final AuthorController ac = new AuthorController();
    final List<AuthorBean> authors = ac.buscarTodosOsAutores();
%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="../../src/core/meta.jsp" %>
        <title>BTK - Gerenciar Autores</title>
        <%@include file="../../src/core/head.jsp" %>
    </head>
    <body>
        <%@include file="../../src/core/header.jsp" %>
        <div class="container-fluid p-5">
            <div class="row align-items-center">
                <div class="col-xs-12 col-sm-12 col-md-8 col-lg-8">
                    <h4>Autores Cadastrados</h4>
                </div>
                <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
                    <a class="btn btn-block btn-primary btn-entrar" href="./keepAuthor.jsp">Adicionar Autor</a>
                </div>
            </div>
            <div class="row mt-4">
                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <div class='table-responsive'>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th scope="col">ID</th>
                                    <th scope="col">Nome</th>
                                    <th scope="col">Sexo</th>
                                    <th scope="col">Idade</th>
                                    <th scope="col">Nacionalidade</th>
                                    <th scope="col">Ações</th>
                                </tr>
                            </thead>
                            <% if (!(authors.isEmpty())) { %>    
                            <tbody>
                                <% for (AuthorBean author : authors) {%>
                                <tr>
                                    <td><%=author.getId()%></td>
                                    <td><%=author.getNome()%></td>
                                    <td><%=author.getSexo()%></td>
                                    <td><%=author.getIdade() == null ? "-" : author.getIdade()%></td>
                                    <td><%=author.getNacionalidade() == null ? "-" : author.getNacionalidade()%></td>
                                    <td>
                                        <a class="btn btn-primary btn-sm btn-block" href="keepAuthor.jsp?ID=<%= author.getId() %>"><span class="fas fa-pencil-alt"></span></a> 
                                        <a class="btn btn-danger btn-sm btn-block" href="../methods/manterAutor.jsp?ID=<%= author.getId() %>&DELETE"><span class="fas fa-trash-alt"></span></a> 
                                    </td>
                                </tr>
                                <% } %>
                            </tbody>
                            <% }%>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../../src/core/footer.jsp" %>
    </body>
</html>
