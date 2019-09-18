<%@page import="java.util.List"%>
<%@page import="Model.BookBean"%>
<%@page import="Controller.BookController"%>

<%
    final BookController bc = new BookController();
    final List<BookBean> books = bc.buscarLivros();
%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="../../src/core/meta.jsp" %>
        <title>BTK - Gerenciar Livros </title>
        <%@include file="../../src/core/head.jsp" %>
    </head>
    <body>
        <%@include file="../../src/core/header.jsp" %>
        <div class="container-fluid p-5">
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-8 col-lg-8">
                    <label for="filterBook">Filtrar</label>
                    <input name="filterBook" autofocus type="text" class="form-control" placeholder="Digite o nome do Livro..."/>
                </div>
                <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
                    <a class="btn btn-block btn-primary btn-entrar top-gutter" href="./keepBook.jsp">Adicionar Livro</a>
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
                                    <th scope="col">Editora</th>
                                    <th scope="col">Gênero</th>
                                    <th scope="col">Autor</th>
                                    <th scope="col">Quantidade</th>
                                    <th scope="col">Ações</th>
                                </tr>
                            </thead>
                            <% if (!(books.isEmpty())) { %>    
                            <tbody>
                                <% for (BookBean book : books) {%>
                                <tr>
                                    <td><%=book.getId()%></td>
                                    <td><%=book.getNome()%></td>
                                    <td><%=book.getEditora()%></td>
                                    <td><%=book.getGenero()%></td>
                                    <td><%=book.getAutor()%></td>
                                    <td><%=book.getQuantidade()%></td>
                                    <td>
                                        <a class="btn btn-primary btn-sm btn-block" href="keepBook.jsp?ID=<%= book.getId() %>"><span class="fas fa-pencil-alt"></span></a> 
                                        <a class="btn btn-danger btn-sm btn-block" href="../methods/manterLivro.jsp?ID=<%= book.getId() %>?ACTION=DELETE"><span class="fas fa-trash-alt"></span></a> 
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
