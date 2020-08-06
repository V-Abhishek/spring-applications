import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;

public class DataByParameterNames extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            response.setContentType("text/html");
            Enumeration paramNames = request.getParameterNames();
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>User Details(Using Parameter Names)</title>");
            out.println("<body>");
            out.println("<h1>User Details</h1>");
            while (paramNames.hasMoreElements()) {
                String paramName = (String) paramNames.nextElement();
                if (paramName.equalsIgnoreCase("email")) {
                    out.println("Email Id: " + request.getParameter(paramName));
                    out.println("<br>");
                }
				if (paramName.equalsIgnoreCase("file")) {
                    out.println("Image: " + request.getParameter(paramName));
                    out.println("<br>");
                }
				if (paramName.equalsIgnoreCase("password")) {
                    out.println("Password: " + request.getParameter(paramName));
                    out.println("<br>");
                }
				if (paramName.equalsIgnoreCase("confirmPassword")) {
                    out.println("Confirm Password: " + request.getParameter(paramName));
                    out.println("<br>");
                }				
                if (paramName.equalsIgnoreCase("gender")) {
                    out.println("Gender: " + request.getParameter(paramName));
                    out.println("<br>");
                }
                if (paramName.equalsIgnoreCase("country")) {
                    out.println("Country: " + request.getParameter(paramName));
                    out.println("<br>");
                }
                if (paramName.equalsIgnoreCase("hobbies")) {
                    out.println("Hobbies: " + Arrays.toString(request.getParameterValues(paramName)).substring(1, Arrays.toString(request.getParameterValues(paramName)).length()-1));
                    out.println("<br>");
                }
                if (paramName.equalsIgnoreCase("address")) {
                    out.println("Address: " + request.getParameter(paramName));
                    out.println("<br>");
                }
            }
            out.println("</body>");
            out.println("</html>");
            out.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}