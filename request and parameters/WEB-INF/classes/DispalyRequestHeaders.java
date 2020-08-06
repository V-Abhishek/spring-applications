import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Abhishek
 */
public class DispalyRequestHeaders extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Enumeration headerNames = request.getHeaderNames();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Request Header Informations</title>");
        out.println("<body>");
        out.println("<h1>Request Header Details</h1>");
        out.println("<TABLE BORDER=1 ALIGN=\"CENTER\">\n" + "<TH>Header Name<TH>Header Value");
        while (headerNames.hasMoreElements()) {
            String headerName = (String) headerNames.nextElement();
            out.println("<TR><TD>" + headerName);
            out.println(" <TD>" + request.getHeader(headerName));
        }
        out.println("</TABLE>");
        out.println("<h1>User Submitted data</h1>");
        out.println("Name: " + request.getParameter("pName"));
        out.println("<br>");
        out.println("Email Id: " + request.getParameter("email"));
        out.println("<br>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

}
