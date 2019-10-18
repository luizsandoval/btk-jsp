
<%@page import="Model.GenderBean"%>
<%@page import="Controller.GenderController"%>
<%
    GenderBean gb = new GenderBean("", "");
    final GenderController gc = new GenderController();

    if (request.getParameter("ID") != null) {
        gb.setId(Integer.parseInt(request.getParameter("ID")));
        gb = gc.buscarGeneroPorID(gb);
    }
%>
<html lang="pt-br">
    <head>
        <%@include file="../../src/core/meta.jsp" %>
        <title>BTK - Manter Gênero</title>
        <%@include file="../../src/core/head.jsp" %>
    </head> 
    <body>

        <%@include file="../../src/core/header.jsp" %>

        <div class="container-fluid p-5">
            <form action="../methods/manterGenero.jsp<%= request.getParameter("ID") != null ? "?ID=" + gb.getId() : "" %>" method="post">
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                        <div class="d-flex align-items-center justify-content-between form-header">
                            <h4 class="modal-title mb-3">Manter Gênero</h4>
                            <span class="text-muted modal-subtitle mb-3">
                                <%= request.getParameter("ID") != null ? "Editar" : "Adicionar"%>
                            </span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                        <div class="form-group">
                            <label for="NOME">Nome do Gênero*</label>
                            <input class="form-control" name="NOME" type="text" autocomplete="off" autofocus value="<%= gb.getNome()%>" autofocus placeholder="Digite o nome do Gênero..." required/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                        <div class="form-group">
                            <label for="DESCRICAO">Descrição</label>
                            <textarea name="DESCRICAO" class="form-control" placeholder="Dê uma breve descrição sobre este Gênero...">
                                <%= gb.getDescricao() == null ? "" : gb.getDescricao()%>
                            </textarea>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                        <div class="d-flex justify-content-end align-items-center">
                            <a class="btn btn-link" href="./manageGenders.jsp" >Voltar</a>
                            <button type="submit" class="btn btn-primary">Salvar Gênero</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>

        <%@include file="../../src/core/footer.jsp" %>
    </body>
</html>