package org.apache.jsp.src.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class manageBooks_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(5);
    _jspx_dependants.add("/src/pages/../../src/core/meta.jsp");
    _jspx_dependants.add("/src/pages/../../src/core/head.jsp");
    _jspx_dependants.add("/src/pages/../../src/core/header.jsp");
    _jspx_dependants.add("/src/pages/../../src/core/./menu.jsp");
    _jspx_dependants.add("/src/pages/../../src/core/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui\">\r\n");
      out.write("<meta name=\"mobile-web-app-capable\" content=\"yes\">\r\n");
      out.write("<meta name=\"apple-mobile-web-app-capable\" content=\"yes\">\r\n");
      out.write("<link rel=\"icon\" href=\"../../assets/img/logo.png\" type=\"image/x-icon\">\r\n");
      out.write("<meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\">");
      out.write("\r\n");
      out.write("        <title>BTK - Gerenciar Livros </title>\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.10.2/css/all.css\">\r\n");
      out.write("<link href=\"../../assets/fonts/Roboto-Thin.ttf\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../../assets/css/bootstrap.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../../assets/css/styles.css\" type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
      out.write("<header>\r\n");
      out.write("    <nav class=\"navbar\">\r\n");
      out.write("        <a class=\"navbar-brand ml-4\" href=\"#\">\r\n");
      out.write("            <img src=\"../../assets/img/logo.png\" class=\"d-inline-block align-top logo-small\" alt=\"BTK - Sistema Bibliotecário\">\r\n");
      out.write("        </a>\r\n");
      out.write("        <button class=\"btn btn-secondary menu-toggle\" onclick=\"openMenu();\">\r\n");
      out.write("            <span class=\"fas fa-bars fa-2x\"></span>\r\n");
      out.write("        </button>\r\n");
      out.write("    </nav>\r\n");
      out.write("    ");
      out.write("<div class=\"menu\" id=\"menu\">\r\n");
      out.write("    <div class=\"menu-header d-flex align-items-center justify-content-end\">\r\n");
      out.write("        <button class=\"btn btn-secondary btn-sq menu-toggle\" onclick=\"closeMenu();\"><span class=\"mr-2\">Fechar</span><span class=\"fas fa-times\"></span></button>\r\n");
      out.write("    </div>\r\n");
      out.write("    <ul class=\"list-group\">\r\n");
      out.write("        <li class=\"list-group-item d-flex flex-direction-column justify-content-center flex-wrap align-items-center pt-4 pb-4 user-info text-center\">\r\n");
      out.write("            <span class=\"fas fa-user-alt fa-3x mb-3\" style=\"width: 100%;\"></span>\r\n");
      out.write("            <span>Nome do Usuário</span>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"list-group-item\">\r\n");
      out.write("            <a class=\"d-flex justify-content-between align-items-center unstyled-link\" href=\"main.jsp\">    \r\n");
      out.write("                <span>Home</span>\r\n");
      out.write("                <span class=\"fas fa-home\"></span>\r\n");
      out.write("            </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"list-group-item\">\r\n");
      out.write("            <a class=\"d-flex justify-content-between align-items-center unstyled-link\" href=\"manageBooks.jsp\">    \r\n");
      out.write("                <span>Gerenciar Livros</span>\r\n");
      out.write("                <span class=\"fas fa-book\"></span>\r\n");
      out.write("            </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"list-group-item\">\r\n");
      out.write("            <a class=\"d-flex justify-content-between align-items-center unstyled-link\">\r\n");
      out.write("                <span>Gerenciar Autores</span>\r\n");
      out.write("                <span class=\"fas fa-users\"></span>\r\n");
      out.write("            </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"list-group-item\">\r\n");
      out.write("            <a class=\"d-flex justify-content-between align-items-center unstyled-link\">\r\n");
      out.write("                <span>Gerenciar Gêneros</span>\r\n");
      out.write("                <span class=\"fas fa-info\"></span>\r\n");
      out.write("            </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"list-group-item\">\r\n");
      out.write("            <a class=\"d-flex justify-content-between align-items-center unstyled-link\">\r\n");
      out.write("                <span>Gerenciar Empréstimos</span>\r\n");
      out.write("                <span class=\"fas fa-arrow-circle-up\"></span>\r\n");
      out.write("            </a>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"list-group-item d-flex justify-content-between align-items-center\">\r\n");
      out.write("            <span>Sair do BTK</span>\r\n");
      out.write("            <span class=\"fas fa-sign-out-alt\"></span>\r\n");
      out.write("        </li>\r\n");
      out.write("    </ul>\r\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("</header>\r\n");
      out.write("<div id=\"overlay\"></div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"container-fluid p-5 d-flex justify-content-center flex-direction-column\">\r\n");
      out.write("            <div class='table-responsive'>\r\n");
      out.write("                <table class=\"table table-hover\">\r\n");
      out.write("                    <thead>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <th scope=\"col\">ID</th>\r\n");
      out.write("                            <th scope=\"col\">Nome</th>\r\n");
      out.write("                            <th scope=\"col\">Editora</th>\r\n");
      out.write("                            <th scope=\"col\">Gênero</th>\r\n");
      out.write("                            <th scope=\"col\">Autor</th>\r\n");
      out.write("                            <th scope=\"col\">Quantidade</th>\r\n");
      out.write("                            <th scope=\"col\">Ações</th>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                    </thead>\r\n");
      out.write("                    <tbody>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <th scope=\"row\">1</th>\r\n");
      out.write("                            <td>Mark</td>\r\n");
      out.write("                            <td>Otto</td>\r\n");
      out.write("                            <td>@mdo</td>\r\n");
      out.write("                            <td>@mdo</td>\r\n");
      out.write("                            <td>@mdo</td>\r\n");
      out.write("                            <td>\r\n");
      out.write("                                <button type=\"button\" class=\"btn btn-primary btn-sm btn-block\"><span class=\"fas fa-pencil-alt\"></span></button> \r\n");
      out.write("                                <button type=\"button\" class=\"btn btn-danger btn-sm btn-block\"><span class=\"fas fa-trash-alt\"></span></button> \r\n");
      out.write("                            </td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                    </tbody>\r\n");
      out.write("                </table>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        ");
      out.write("<footer>\r\n");
      out.write("    <small> Copyright &copy;\r\n");
      out.write("        Luiz Sandoval, Matheus Fiaschi - 2019. Todos os direitos reservados.</small>\r\n");
      out.write("\r\n");
      out.write("    <script src=\"../../assets/js/jquery-3.3.1.slim.min.js\"></script>\r\n");
      out.write("    <script src=\"../../assets/js/popper.min.js\"></script>\r\n");
      out.write("    <script src=\"../../assets/js/bootstrap.min.js\"></script>\r\n");
      out.write("    <script>\r\n");
      out.write("        let overlay = document.getElementById('overlay');\r\n");
      out.write("        let menu = document.getElementById('menu');\r\n");
      out.write("\r\n");
      out.write("        overlay.addEventListener('click', () => closeMenu());\r\n");
      out.write("\r\n");
      out.write("        function openMenu() {\r\n");
      out.write("            menu.style.right = '0px';\r\n");
      out.write("            overlay.style.display = 'block';\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        function closeMenu() {\r\n");
      out.write("            menu.style.right = '-300px';\r\n");
      out.write("            overlay.style.display = 'none';\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("    </script>\r\n");
      out.write("</footer>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
