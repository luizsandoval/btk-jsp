<!DOCTYPE html>
<html>
    <head>
        <%@include file="../../src/core/meta.jsp" %>
        <title>BTK - Gerenciar Livros </title>
        <%@include file="../../src/core/head.jsp" %>
    </head>
    <body>
        <%@include file="../../src/core/header.jsp" %>
        <div class="container-fluid p-5 d-flex justify-content-center flex-direction-column">
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
                    <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>Mark</td>
                            <td>Otto</td>
                            <td>@mdo</td>
                            <td>@mdo</td>
                            <td>@mdo</td>
                            <td>
                                <button type="button" class="btn btn-primary btn-sm btn-block"><span class="fas fa-pencil-alt"></span></button> 
                                <button type="button" class="btn btn-danger btn-sm btn-block"><span class="fas fa-trash-alt"></span></button> 
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <%@include file="../../src/core/footer.jsp" %>
    </body>
</html>
