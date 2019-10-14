
<%@page import="Controller.LoanController"%>
<%@include file="../methods/verificarUsuarioLogado.jsp" %>

<%
    final LoanController lc = new LoanController();
    
    final int totalEmprestimos = lc.buscarQuantidadeDeEmprestimos();
    final int emprestimosAtrasados = lc.buscarQuantidadeDeEmprestimosAtrasados();
    final int emprestimosEmAberto = lc.buscarQuantidadeDeEmprestimosEmAberto();
    final int emprestimosFinalizados = lc.buscarQuantidadeDeEmprestimosFinalizados();

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
        <div class="container-fluid d-flex justify-content-around flex-direction-column mt-4">
            <div class="row flex-grow-1">
                 <div class="col-xs-12 col-sm-12 col-md-3 col-lg-3 col-xl-3">
                    <div class="card text-white bg-info mb-3 flex-column-reverse">
                        <div class="card-header">Total de Empréstimos</div>
                        <div class="card-body d-flex justify-content-between align-items-center">
                            <h1 style="font-size: 4em;"><%= totalEmprestimos %></h1>
                            <span class="fas fa-users fa-3x"></span>
                        </div>
                    </div>
                </div>
                <div class="col-xs-12 col-sm-12 col-md-3 col-lg-3 col-xl-3">
                    <div class="card text-white bg-danger mb-3 d-flex flex-column-reverse">
                        <div class="card-header">Empréstimos Atrasados</div>
                        <div class="card-body d-flex justify-content-between align-items-center">
                            <h1 style="font-size: 4em;"><%= emprestimosAtrasados %></h1>
                            <span class="fas fa-calendar-times fa-3x"></span>
                        </div>
                    </div>
                </div>
                <div class="col-xs-12 col-sm-12 col-md-3 col-lg-3 col-xl-3">
                    <div class="card text-white bg-warning mb-3 flex-column-reverse">
                        <div class="card-header">Empréstimos em Aberto</div>
                        <div class="card-body d-flex justify-content-between align-items-center">
                            <h1 style="font-size: 4em;"><%= emprestimosEmAberto %></h1>
                            <span class="fas fa-arrow-circle-up fa-3x"></span>
                        </div>
                    </div>
                </div>
                <div class="col-xs-12 col-sm-12 col-md-3 col-lg-3 col-xl-3">
                    <div class="card text-white bg-success mb-3 flex-column-reverse">
                        <div class="card-header">Empréstimos Finalizados</div>
                        <div class="card-body d-flex justify-content-between align-items-center">
                            <h1 style="font-size: 4em;"><%= emprestimosFinalizados %></h1>
                            <span class="fas fa-check-circle fa-3x"></span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../../src/core/footer.jsp" %>
    </body>
</html>
