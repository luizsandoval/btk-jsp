
<%@page import="Model.AuthorBean"%>
<%@page import="Controller.AuthorController"%>
<% 
    AuthorBean ab = new AuthorBean("", "", "", "");
    final AuthorController ac = new AuthorController();
    
    if(request.getParameter("ID") != null) {
        ab.setId(Integer.parseInt(request.getParameter("ID")));
        ab = ac.buscarAutorPorID(ab);
    }
%>
<html lang="pt-br">
    <head>
        <%@include file="../../src/core/meta.jsp" %>
        <title>BTK - Manter Autor</title>
        <%@include file="../../src/core/head.jsp" %>
    </head> 
    <body>

        <%@include file="../../src/core/header.jsp" %>

        <div class="container-fluid p-5">
            <form action="../methods/manterAutor.jsp<%= request.getParameter("ID") != null ? "?ID=" + ab.getId() : "" %>" method="post">
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                        <div class="d-flex align-items-center justify-content-between form-header">
                            <h4 class="modal-title mb-3">Manter Autor</h4>
                            <span class="text-muted modal-subtitle mb-3">
                                <%= request.getParameter("ID") != null ? "Editar" : "Adicionar"%>
                            </span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-8 col-lg-8">
                        <div class="form-group">
                            <label for="NOME">Nome do Autor*</label>
                            <input class="form-control" name="NOME" type="text" autocomplete="off" value="<%= ab.getNome() %>" autofocus placeholder="Digite o nome do autor..." required/>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
                        <div class="form-group">
                            <label for="SEXO">Sexo*</label>
                            <select name="SEXO" class="form-control" required>
                                <option value="" <%= ab.getSexo().equals("") ? "selected" : "" %>>Selecione um Sexo...</option>
                                <option value="Masculino" <%= ab.getSexo().equals("Masculino") ? "selected" : "" %>>Masculino</option>
                                <option value="Feminino" <%= ab.getSexo().equals("Feminino") ? "selected" : "" %>>Feminino</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                        <div class="form-group">
                            <label for="IDADE">Idade</label>
                            <input name="IDADE" autocomplete="off" value="<%= ab.getIdade() %>" class="form-control" type="number" placeholder="Digite a idade do Autor..."/>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                        <div class="form-group">
                            <label for="NACIONALIDADE">Nacionalidade</label>
                            <input name="NACIONALIDADE" autocomplete="off" value="<%= ab.getNacionalidade() %>" class="form-control" type="text" placeholder="Digite a nacionalidade do Autor..."/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                        <div class="d-flex justify-content-end align-items-center">
                            <a class="btn btn-link" href="./manageAuthors.jsp" >Voltar</a>
                            <button type="submit" class="btn btn-primary">Salvar Autor</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>

        <%@include file="../../src/core/footer.jsp" %>
    </body>
</html>