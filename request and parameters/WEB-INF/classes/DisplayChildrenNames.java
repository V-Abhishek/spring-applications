import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayChildrenNames extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Children Names</title>");
        out.println("<body>");
        out.println("<h1>Your children names are</h1>");
        out.println(request.getParameter("child1"));
        out.println("<br>");
        out.println(request.getParameter("child2"));
        out.println("<br>");
        out.println(request.getParameter("child3"));
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
