package org.apache.jsp.src.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/src/pages/../../src/core/meta.jsp");
    _jspx_dependants.add("/src/pages/../../src/core/head.jsp");
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

      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        ");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui\">\n");
      out.write("<meta name=\"mobile-web-app-capable\" content=\"yes\">\n");
      out.write("<meta name=\"apple-mobile-web-app-capable\" content=\"yes\">\n");
      out.write("<link rel=\"icon\" href=\"../../assets/img/logo.png\" type=\"image/x-icon\">\n");
      out.write("<meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\">");
      out.write("\n");
      out.write("        <title>BTK - Sistema Bibliotecário | Registrar-se</title>\n");
      out.write("        ");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.10.2/css/all.css\">\n");
      out.write("<link href=\"../../assets/fonts/Roboto-Thin.ttf\">\n");
      out.write("<link rel=\"stylesheet\" href=\"../../assets/css/bootstrap.min.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"../../assets/css/styles.css\" type=\"text/css\">\n");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container login-page d-flex justify-content-center align-items-center flex-direction-column\">\n");
      out.write("            <form action=\"\" method=\"post\" name=\"loginForm\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-xs-12 col-sm-12 col-md-12 col-lg-12 text-center\">\n");
      out.write("                        <img src=\"../../assets/img/logo.png\" class=\"logo-medium\"/>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-xs-12 col-sm-12 col-md-12 col-lg-12\">                        \n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"EMAIL\">E-mail*</label>\n");
      out.write("                            <input name=\"EMAIL\" autofocus class=\"form-control email-login\" placeholder=\"nome@exemplo.com\" type=\"email\" required/>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-xs-12 col-sm-12 col-md-12 col-lg-12\">                        \n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"SENHA\">Senha*</label>\n");
      out.write("                            <input name=\"SENHA\" class=\"form-control\" placeholder=\"Digite sua senha ultra secreta...\" type=\"password\" required/>\n");
      out.write("                            <small class=\"form-text text-muted\">Não se preocupe, sua senha é ultra secreta.</small>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-xs-12 col-sm-12 col-md-12 col-lg-12\">                        \n");
      out.write("                        <button disabled type=\"submit\" class=\"btn btn-block btn-primary btn-entrar\">Cadastrar-se agora</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        ");
      out.write("<footer>\n");
      out.write("    <small> Copyright &copy;\n");
      out.write("        Luiz Sandoval, Matheus Fiaschi - 2019. Todos os direitos reservados.</small>\n");
      out.write("\n");
      out.write("    <script src=\"../../assets/js/jquery-3.3.1.slim.min.js\"></script>\n");
      out.write("    <script src=\"../../assets/js/popper.min.js\"></script>\n");
      out.write("    <script src=\"../../assets/js/bootstrap.min.js\"></script>\n");
      out.write("    <script>\n");
      out.write("        let overlay = document.getElementById('overlay');\n");
      out.write("        let menu = document.getElementById('menu');\n");
      out.write("\n");
      out.write("        overlay.addEventListener('click', () => turnOverlayOFF());\n");
      out.write("\n");
      out.write("        function turnOverlayON() {\n");
      out.write("            menu.style.right = '0px';\n");
      out.write("            overlay.style.display = 'block';\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function turnOverlayOFF() {\n");
      out.write("            menu.style.right = '-300px';\n");
      out.write("            overlay.style.display = 'none';\n");
      out.write("        }\n");
      out.write("\n");
      out.write("    </script>\n");
      out.write("</footer>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
