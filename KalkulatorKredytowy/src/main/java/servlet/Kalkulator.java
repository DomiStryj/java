package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/index")
public class Kalkulator extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String kwota= req.getParameter("kwota");
        String raty= req.getParameter("raty");
        String oprocentowanieKredytu= req.getParameter("oprocentowanieKredytu");
        String oplataStala= req.getParameter("oplataStala");
        String rodzajRat= req.getParameter("rodzajRat");

        if (kwota==null || kwota.isEmpty()||
                raty==null || raty.isEmpty()||
                oprocentowanieKredytu==null || oprocentowanieKredytu.isEmpty()||
                oplataStala== null || oplataStala.isEmpty()||
                rodzajRat == null || rodzajRat.isEmpty())
        {
            resp.sendRedirect("/blad.jsp");
        }
        else
        {
            double kwotaKredytu = Double.parseDouble(req.getParameter("kwota"));
            int iloscRat = Integer.parseInt(req.getParameter("raty"));
            double oprocentowanie = Double.parseDouble(req.getParameter("oprocentowanieKredytu"));
            double stala = Double.parseDouble(req.getParameter("oplataStala"));
            String rodzaj = req.getParameter("rodzajRat");

            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");

            PrintWriter writer = resp.getWriter();
            writer.append("<!DOCTYPE html>\r\n")
                    .append("<html>\r\n")
                    .append("<head>\r\n")
                    .append("<meta http-equiv=\"Content-Type\" content=\"text/html\" charset=\"ISO-8859-1\">\r\n")
                    .append("<title>Kalukator spłat kredytu</title>\r\n")
                    .append("</head>\r\n")
                    .append("<body>\r\n")
                    .append("<table>\r\n")
                    .append("<tr>\r\n")
                    .append("<th>Numer raty</th>\r\n")
                    .append("<th>Kapital</th>\r\n")
                    .append("<th>Odsetki</th>\r\n")
                    .append("<th>Oplaty stale</th>\r\n")
                    .append("<th>Kwota calkowita</th>\r\n")
                    .append("</tr>\r\n");
            double rataOpłaty =stala/iloscRat;
            if (rodzaj.equals("stala_wysokosc"))
            {
                for (int id = 1, i = 0; id <= iloscRat; id++, i++) {
                    double wspolczynnik = 1+(oprocentowanie/12);
                    double kapitalowaCzescRaty =kwotaKredytu * oprocentowanie/12 * Math.pow(wspolczynnik, i)
                            / (Math.pow(wspolczynnik, iloscRat) - 1);
                    double odsetkowaCzescRaty = kwotaKredytu* oprocentowanie/12 * (Math.pow(wspolczynnik, iloscRat)
                            - Math.pow(wspolczynnik, i)) / (Math.pow(wspolczynnik, iloscRat) - 1);
                    double calkowitaKwotaRaty = kapitalowaCzescRaty + iloscRat + odsetkowaCzescRaty;
                    writer.append("<tr>\r\n")
                            .append("<td>" + id + "</td>\r\n")
                            .append("<td>" + kapitalowaCzescRaty + "</td>\r\n")
                            .append("<td>" + odsetkowaCzescRaty + "</td>\r\n")
                            .append("<td>" + rataOpłaty + "</td>\r\n")
                            .append("<td>" + calkowitaKwotaRaty + "</td>\r\n")
                            .append("</tr>\r\n");
                }

            }
            else if(rodzajRat.equals("raty_malejace"))
            {

                for (int id = 1, i = 0; id <= iloscRat; id++, i++) {
                    double kapitalowaCzescRaty = kwotaKredytu/iloscRat;

                    double calkowitaKwotaRaty = kapitalowaCzescRaty + iloscRat ;
                    writer.append("<tr>\r\n")
                            .append("<td>" + id + "</td>\r\n")
                            .append("<td>" + kapitalowaCzescRaty + "</td>\r\n")

                            .append("<td>" + iloscRat + "</td>\r\n")
                            .append("<td>" + calkowitaKwotaRaty + "</td>\r\n")
                            .append("</tr>\r\n");
                }
            }
            writer.append("</table>\r\n")
                    .append("</body>\r\n")
                    .append("</html>\r\n");
        }

    }

}

