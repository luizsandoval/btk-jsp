
<%@page import="Controller.BookController"%>
<%@page import="Model.BookBean"%>
<% 
    BookBean bb = new BookBean("", "", "","", "", 0);
    final BookController bc = new BookController();
    
    if(request.getParameter("ID") != null) {
        bb.setId(Integer.parseInt(request.getParameter("ID")));
        bb = bc.buscarLivroPorID(bb);
    }
%>
<html lang="pt-br">
    <head>
        <%@include file="../../src/core/meta.jsp" %>
        <title>BTK - Manter Livro</title>
        <%@include file="../../src/core/head.jsp" %>
    </head> 
    <body>

        <%@include file="../../src/core/header.jsp" %>

        <div class="container-fluid p-5">
            <form action="../methods/manterLivro.jsp" method="post">
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                        <div class="d-flex align-items-center justify-content-between form-header">
                            <h4 class="modal-title mb-3">Manter Livro</h4>
                            <span class="text-muted modal-subtitle mb-3">
                                <%= request.getParameter("ID") != null ? "Editar" : "Adicionar"%>
                            </span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                        <div class="form-group">
                            <label for="NOME">Nome do Livro*</label>
                            <input class="form-control" name="NOME" type="text" autocomplete="off" value="<%= bb.getNome() %>" autofocus placeholder="Digite o nome do livro..." required/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                        <div class="form-group">
                            <label for="GENERO">Gênero*</label>
                            <select name="GENERO" class="form-control" required>
                                <option value="">Selecione um gênero...</option>
                                <option value="Aventura">Aventura</option>
                                <option value="Infanto Juvenil">Infanto Juvenil</option>
                                <option value="Romance">Romance</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                        <div class="form-group">
                            <label for="AUTOR">Autor*</label>
                            <select name="AUTOR" class="form-control" required>
                                <option value="">Selecione um autor...</option>
                                <option value="JK Rownling">JK Rownling</option>
                                <option value="Rick Riordan">Rick Riordan</option>
                                <option value="Suzanne Collins">Suzanne Collins</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                        <div class="form-group">
                            <label for="EDITORA">Editora</label>
                            <input name="EDITORA" autocomplete="off" value="<%= bb.getEditora() %>" class="form-control" type="text" placeholder="Digite o nome da Editora..."/>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                        <div class="form-group">
                            <label for="QUANTIDADE">Quantidade*</label>
                            <input name="QUANTIDADE" class="form-control" value="<%= bb.getQuantidade() > 0 ? bb.getQuantidade() : "" %>" type="number" placeholder="Digite a quantidade de exemplares..." required/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                         <div class="form-group">
                            <label for="DESCRICAO">Descrição</label>
                            <textarea name="DESCRICAO" class="form-control" placeholder="Digite uma breve descrição deste livro..."><%= bb.getDescricao() %></textarea>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                        <div class="d-flex justify-content-end align-items-center">
                            <a class="btn btn-link" href="./manageBooks.jsp" >Voltar</a>
                            <button type="submit" class="btn btn-primary">Salvar Livro</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>

        <%@include file="../../src/core/footer.jsp" %>
    </body>
</html>