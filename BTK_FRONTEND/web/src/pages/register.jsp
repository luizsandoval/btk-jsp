<!DOCTYPE html>
<html>
    <head>
        <%@include file="../../src/core/meta.jsp" %>
        <title>BTK - Registrar-se</title>
        <%@include file="../../src/core/head.jsp" %>
    </head>
    <body>
        <div class="container login-page d-flex justify-content-center align-items-center flex-direction-column">
            <form action="" method="post" name="loginForm">
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-center">
                        <img src="../../assets/img/logo.png" class="logo-medium"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">                        
                        <div class="form-group">
                            <label for="NOME">Nome Completo*</label>
                            <input name="NOME" autofocus class="form-control email-login" placeholder="João da Silva" type="text" required/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">                        
                        <div class="form-group">
                            <label for="EMAIL">E-mail*</label>
                            <input name="EMAIL" class="form-control email-login" placeholder="nome@exemplo.com" type="email" required/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">                        
                        <div class="form-group">
                            <label for="SENHA">Senha*</label>
                            <input name="SENHA" class="form-control" placeholder="Digite sua senha" type="password" required/>
                            <small class="form-text text-muted">Não se preocupe, sua senha é ultra secreta.</small>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">                        
                        <button disabled type="submit" class="btn btn-block btn-primary btn-entrar">Cadastrar-se agora</button>
                    </div>
                </div>
                 <div class="row mt-3">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">                        
                        <a class="btn btn-link" href="login.jsp">Retornar ao Login</a>
                    </div>
                </div>
            </form>
        </div>
        <%@include file="../../src/core/footer.jsp" %>
    </body>
</html>
