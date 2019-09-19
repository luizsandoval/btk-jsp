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
                    <label for="filterBook">Nome</label>
                    <input name="filterBook" autofocus type="text" class="form-control genero-nome" placeholder="Digite o nome do Gênero..."/>
                    <label for="filterBook">Descrição</label>
                    <textarea name="filterBook" autofocus type="text" class="form-control text-descricao" placeholder="Digite a descrição do Livro..."> </textarea>

                </div>
                <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
                    <a style="margin-top: 30px;" class="btn btn-block btn-primary btn-entrar top-gutter" href="./keepBook.jsp">Adicionar Gênero</a>
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
                                </tr>
                            </thead>
                          
                                <tr>
                                    <td>tet</td>
                                    <td>te></td>
                                    <td>tet</td>
                                    <td>
                                      <button type="button" class="btn btn-primary btn-sm btn-block"><span class="fas fa-pencil-alt"></span></button> 
                                      <button type="button" class="btn btn-danger btn-sm btn-block"><span class="fas fa-trash-alt"></span></button> 
                                    </td>
                                </tr>
                               
                                
                            </tbody>
                      
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../../src/core/footer.jsp" %>
    </body>
</html>
