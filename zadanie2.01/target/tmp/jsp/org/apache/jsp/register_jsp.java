package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<body>\r\n");
      out.write("<form action=\"register\" method=\"post\">\r\n");
      out.write("    <a href=\"index.jsp\">Zaloguj</a>\r\n");
      out.write("\r\n");
      out.write("    <title>Rejestracja</title>\r\n");
      out.write("    <h3>Rejestracja</h3>\r\n");
      out.write("    <table>\r\n");
      out.write("        Nazwa uzytkownika:<br/>\r\n");
      out.write("        <input name=\"user\"><br/>\r\n");
      out.write("        Haslo :<br/>\r\n");
      out.write("        <input name=\"password\" type=\"password\"><br/>\r\n");
      out.write("        Potwierdz haslo:<br/>\r\n");
      out.write("        <input name=\"confPassword\" type=\"password\"><br/>\r\n");
      out.write("        E-mail:<br/>\r\n");
      out.write("        <input name=\"email\"><br/>\r\n");
      out.write("        <td/>\r\n");
      out.write("        <br><input type=\"submit\" value=\"Rejestruj\" name=\"regis\">\r\n");
      out.write("    </table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</form>\r\n");
      out.write("</head>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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
