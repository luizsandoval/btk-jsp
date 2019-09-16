<div class="menu" id="menu">
    <div class="menu-header d-flex align-items-center justify-content-end p-3">
        <button class="btn btn-secondary btn-sq menu-toggle" onclick="closeMenu();"><span class="mr-2">Fechar</span><span class="fas fa-times"></span></button>
    </div>
    <ul class="list-group">
        <li class="list-group-item d-flex flex-direction-column justify-content-center flex-wrap align-items-center pt-4 pb-4 user-info text-center">
            <span class="fas fa-user-alt fa-3x mb-3" style="width: 100%;"></span>
            <span><%  out.print(session.getAttribute("username")); %>
            </span>
        </li>
        <li class="list-group-item">
            <a class="d-flex justify-content-between align-items-center unstyled-link" href="main.jsp">    
                <span>Home</span>
                <span class="fas fa-home"></span>
            </a>
        </li>
        <li class="list-group-item">
            <a class="d-flex justify-content-between align-items-center unstyled-link" href="manageBooks.jsp">    
                <span>Gerenciar Livros</span>
                <span class="fas fa-book"></span>
            </a>
        </li>
        <li class="list-group-item">
            <a class="d-flex justify-content-between align-items-center unstyled-link">
                <span>Gerenciar Autores</span>
                <span class="fas fa-users"></span>
            </a>
        </li>
        <li class="list-group-item">
            <a class="d-flex justify-content-between align-items-center unstyled-link">
                <span>Gerenciar Gêneros</span>
                <span class="fas fa-info"></span>
            </a>
        </li>
        <li class="list-group-item">
            <a class="d-flex justify-content-between align-items-center unstyled-link">
                <span>Gerenciar Empréstimos</span>
                <span class="fas fa-arrow-circle-up"></span>
            </a>
        </li>
        <li class="list-group-item d-flex justify-content-between align-items-center">
            <span>Sair do BTK</span>
            <span class="fas fa-sign-out-alt"></span>
        </li>
    </ul>
</div>
            