
<%@page import="java.util.List"%>
<%@page import="Model.LoanBean"%>
<%@page import="Controller.LoanController"%>
<%@include file="../methods/verificarUsuarioLogado.jsp" %>

<%    
    final LoanController lc = new LoanController();

    final int totalEmprestimos = lc.buscarQuantidadeDeEmprestimos();
    final int emprestimosAtrasados = lc.buscarQuantidadeDeEmprestimosAtrasados();
    final int emprestimosEmAberto = lc.buscarQuantidadeDeEmprestimosEmAberto();
    final int emprestimosFinalizados = lc.buscarQuantidadeDeEmprestimosFinalizados();
    
    final String loggedUserName = ((UserBean) session.getAttribute("loggedUser")).getNome();

    final int loanType = request.getParameter("TYPE") != null ? Integer.parseInt(request.getParameter("TYPE")) : 0;
    
    List<LoanBean> loans;
    
    switch (loanType) {
        case 1: {
            loans = lc.buscarEmprestimosAtrasados();
            break;
        }
        case 2: {
            loans = lc.buscarEmprestimosEmAberto();
            break;
        }
        case 3: {
            loans = lc.buscarEmprestimosFinalizados();
            break;
        }
        default: {
            loans = lc.buscarTodosOsEmprestimos();
        }
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
        <div class="container-fluid d-flex justify-content-around flex-direction-column pb-2 pl-5 pr-5 pt-4">
            <div class="row flex-grow-1">
                <div class="col-xs-12 col-sm-12 col-md-3 col-lg-3 col-xl-3">
                    <div class="card text-white bg-info mb-3 flex-column-reverse" onclick="getLoans(0)">
                        <div class="card-header">Total de Empréstimos</div>
                        <div class="card-body d-flex justify-content-between align-items-center">
                            <h1 style="font-size: 4em;"><%= totalEmprestimos%></h1>
                            <span class="fas fa-book-open fa-3x"></span>
                        </div>
                    </div>
                </div>
                <div class="col-xs-12 col-sm-12 col-md-3 col-lg-3 col-xl-3">
                    <div class="card text-white bg-danger mb-3 d-flex flex-column-reverse" onclick="getLoans(1)">
                        <div class="card-header">Empréstimos Atrasados</div>
                        <div class="card-body d-flex justify-content-between align-items-center">
                            <h1 style="font-size: 4em;"><%= emprestimosAtrasados%></h1>
                            <span class="fas fa-calendar-times fa-3x"></span>
                        </div>
                    </div>
                </div>
                <div class="col-xs-12 col-sm-12 col-md-3 col-lg-3 col-xl-3">
                    <div class="card text-white bg-warning mb-3 flex-column-reverse" onclick="getLoans(2)">
                        <div class="card-header">Empréstimos em Aberto</div>
                        <div class="card-body d-flex justify-content-between align-items-center">
                            <h1 style="font-size: 4em;"><%= emprestimosEmAberto%></h1>
                            <span class="fas fa-arrow-circle-up fa-3x"></span>
                        </div>
                    </div>
                </div>
                <div class="col-xs-12 col-sm-12 col-md-3 col-lg-3 col-xl-3">
                    <div class="card text-white bg-success mb-3 flex-column-reverse" onclick="getLoans(3)">
                        <div class="card-header">Empréstimos Finalizados</div>
                        <div class="card-body d-flex justify-content-between align-items-center">
                            <h1 style="font-size: 4em;"><%= emprestimosFinalizados%></h1>
                            <span class="fas fa-check-circle fa-3x"></span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container-fluid pl-5 pr-5 pb-5">
            <div class="row flex-grow-1">
                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <div class='table-responsive'>
                        <table class="table table-hover" id="loansTable">
                            <thead>
                                <tr>
                                    <th scope="col">ID</th>
                                    <th scope="col">Locador</th>
                                    <th scope="col">Locatário</th>
                                    <th scope="col">Livro</th>
                                    <th scope="col">D. Empréstimo</th>
                                    <th scope="col">D. Devolução.</th>
                                    <th scope="col">Status</th>
                                    <th scope="col">Devolver</th>
                                </tr>
                            </thead>
                            <% if (!(loans.isEmpty())) { %>    
                            <tbody>
                                <% for (LoanBean loan : loans) {%>
                                <tr>
                                    <td><%=loan.getId()%></td>
                                    <td><%=loan.getNomeUsuario()%></td>
                                    <td><%=loan.getNomeLocatario()%></td>
                                    <td><%=loan.getNomeLivro()%></td>
                                    <td><%=loan.getDataEmprestimo()%></td>
                                    <td><%= loan.getStatus().equals("Em Aberto") ? loan.getDataDevolucao() : loan.getDataDevolucaoReal()%></td>
                                    <td><%=loan.getStatus()%></td>
                                    <td>
                                        <a class="btn btn-primary btn-sm btn-block <%= loan.getStatus().equals("Finalizado") || !loan.getNomeUsuario().equals(loggedUserName) ? "disabled" : ""%>" href="../methods/manterEmprestimo.jsp?ID=<%= loan.getId()%>"><span class="fas fa-arrow-down"></span></a> 
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
