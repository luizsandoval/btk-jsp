<%-- 
    Document   : emprestimo
    Created on : 15/09/2019, 16:46:15
    Author     : T-Gamer
--%>

<html>
    <head>
        <%@include file="../../src/core/meta.jsp" %>
        <title>BTK - Sistema Bibliotecário | Login</title>
        <%@include file="../../src/core/head.jsp" %>
    </head>
    <body>
        <div class="containerTelaEmprestimo d-flex justify-content-center align-items-center flex-direction-column">
             <%@include file="../../src/core/header.jsp" %>
             <p class="txt-obra"> Obra </p>
            <div class="container-obra"> 
                <p class="text-empretimo">Tombo</p>
                <input class="input-tombo input-empretimo" type="name"> 
                <p class="text-empretimo">Titulo da Obra</p>
                <input class="input-titulo input-empretimo" type="name"> 
                <p class="text-empretimo">Quantidade</p>
                <input class="input-qtd" type="name"> 
            </div>
              <p class="txt-obra"> Dados Do Emprestimo </p>
            <div class="container-dadosEprestimo"> 
                         <div class='table-responsive table-emprestimo'>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th scope="col">Nº de Tombo</th>
                            <th scope="col">Título</th>
                            <th scope="col">Autor</th>
                            <th scope="col">Editora</th>
                            <th scope="col">Gênero</th>
                            <th scope="col">Edição</th>
                            <th scope="col">Ano</th>
                            <th scope="col">Qtd</th>
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
                            <td>@mdo</td>
                            <td>@mdo</td>
                          
  
                            </td>
                        </tr>
                    </tbody>
                </table>
                         </div>
                <div class="container-btn-emprestimo">
             <p> Data Emprestimo </p>
             <input type="date" class="data-emprestimo input-dateEmprestimo"><br>
             <p> Data Devolução </p>
             <input type="date" class="data-devolução input-dateEmprestimo">
            </div></div>
            <div class="container-buttonsEmprestimo"> 
                    <button type="button" class="btn btn-primary btn-sm btn-block btn-emprestimo"><span class="fas fa-pencil-alt"></span></button> 
                    <button type="button" class="btn btn-danger btn-sm btn-block btn-emprestimo"><span class="fas fa-trash-alt"></span></button>
            </div>

            <!-- <form action="" method="post" name="loginForm">
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-center">
                        <img src="../../assets/img/logo.png" class="logo-medium"/>
                    </div>
                </div>
                
               </form>--> <%@include file="../../src/core/footer.jsp" %>
                </div>
        
       
    </body>
</html>