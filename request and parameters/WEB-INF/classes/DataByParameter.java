import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.http.Part;

public class DataByParameter extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            response.setContentType("text/html");
            String email = request.getParameter("email");
            String imageName = request.getParameter("file");
            String gender = request.getParameter("gender");
            String country = request.getParameter("country");
            String[] hobbies = request.getParameterValues("hobbies");
            String address = request.getParameter("address");
			String password = request.getParameter("password");
			String confirmPassword = request.getParameter("confirmPassword");			
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>User Details</title>");
            out.println("<body>");
            out.println("<h1>User Details</h1>");
            out.println("Email Id: " + email);
            out.println("<br>");
            out.println("Image: " + imageName);
            out.println("<br>");
			out.println("Password: " + password);
			out.println("<br>");
			out.println("Confirm Password: " + confirmPassword);
			out.println("<br>");
            out.println("Gender: " + gender);
            out.println("<br>");
            out.println("Country: " + country);
            out.println("<br>");
            out.println("Hobbies: " + Arrays.toString(hobbies).substring(1, Arrays.toString(hobbies).length()-1));
            out.println("<br>");
            out.println("Address: " + address);
            out.println("</body>");
            out.println("</html>");
            out.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
