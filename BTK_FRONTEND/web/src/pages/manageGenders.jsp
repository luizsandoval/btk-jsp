<%@page import="java.util.List"%>
<%@page import="Model.GenderBean"%>
<%@page import="Controller.GenderController"%>
<%
    final GenderController gc = new GenderController();
    final List<GenderBean> genders = gc.buscarGeneros();
%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="../../src/core/meta.jsp" %>
        <title>BTK - Gerenciar Gêneros</title>
        <%@include file="../../src/core/head.jsp" %>
    </head>
    <body>
        <%@include file="../../src/core/header.jsp" %>
        <div class="container-fluid p-5">
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-8 col-lg-8">
                    <label for="filterGender">Filtrar</label>
                    <input name="filterGender" autofocus type="text" class="form-control" placeholder="Digite o nome do Gênero..."/>
                </div>
                <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
                    <a class="btn btn-block btn-primary btn-entrar top-gutter" href="./keepGender.jsp">Adicionar Gênero</a>
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
                                    <th scope="col">Descrição</th>
                                    <th scope="col">Ações</th>
                                </tr>
                            </thead>
                            <% if (!(genders.isEmpty())) { %>    
                            <tbody>
                                <% for (GenderBean gender : genders) {%>
                                <tr>
                                    <td><%=gender.getId()%></td>
                                    <td><%=gender.getNome()%></td>
                                    <td><%=gender.getDescricao() == null ? "-" : gender.getDescricao()%></td>
                                    <td>
                                        <a class="btn btn-primary btn-sm btn-block" href="keepGender.jsp?ID=<%= gender.getId() %>"><span class="fas fa-pencil-alt"></span></a> 
                                        <a class="btn btn-danger btn-sm btn-block" href="../methods/manterGenero.jsp?ID=<%= gender.getId() %>&ACTION=DELETE"><span class="fas fa-trash-alt"></span></a> 
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
