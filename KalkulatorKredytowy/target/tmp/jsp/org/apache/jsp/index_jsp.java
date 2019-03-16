package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Kredyt</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<form action=\"index\" method=\"post\"></form>\n");
      out.write("<h3>Kalkulator kredytowy: </h3>\n");
      out.write("<table>\n");
      out.write("    Wnioskowana kwota kredytu</br>\n");
      out.write("    <input type=\"number\" min=\"1\" name=\"kwota\"><br/>\n");
      out.write("    Ilosc rat :<br/>\n");
      out.write("    <input type=\"number\" min=\"3\" max=\"50\" name=\"raty\">(minimum 3 maksimum 50)<br/>\n");
      out.write("    Oprocentowanie kredytu: <br/>\n");
      out.write("    <input type=\"number\" min=\"0\" name=\"oprocentowanie\" ><br/>\n");
      out.write("    Oplata stala:<br/>\n");
      out.write("    <input name=\"oplataStala\" type=\"number\" ><br/>\n");
      out.write("    Rodzaj rat:<br/>\n");
      out.write("    <select name=\"rodzajRat\">\n");
      out.write("        <option value=\"stala_wysokosc_rat\">stala wysokosc rat</option>\n");
      out.write("        <option value=\"raty_malejace\">raty malejace</option>\n");
      out.write("</table>\n");
      out.write("<br><input type=\"submit\" value=\"Oblicz\" name=\"oblicz\">\n");
      out.write("</form>\n");
      out.write("</table>\n");
      out.write("</body>\n");
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
