/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Abhishek
 */
public class DisplayCart extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            System.out.println("Order Type" + request.getParameter("orderType"));
            String orderType = request.getParameter("orderType");
            if (orderType.equalsIgnoreCase("books")) {
                String[] orders = request.getParameterValues("order");
                HttpSession httpSession = request.getSession(false);
                if (httpSession != null) {
                    if (httpSession.getAttribute("Products") == null) {
                        httpSession.setAttribute("Products", Arrays.toString(orders));
                    } else {
                        String existing = (String) httpSession.getAttribute("Products");
                        httpSession.setAttribute("Products", existing + Arrays.toString(orders));
                    }

                }
                System.out.println(httpSession.getId());
                System.out.println(httpSession.getAttribute("Products").toString());
            }
            if (orderType.equalsIgnoreCase("music")) {
                String[] orders = request.getParameterValues("order");
                HttpSession httpSession = request.getSession(false);
                if (httpSession != null) {
                    if (httpSession.getAttribute("Products") == null) {
                        httpSession.setAttribute("Products", Arrays.toString(orders));
                    } else {
                        String existing = (String) httpSession.getAttribute("Products");
                        httpSession.setAttribute("Products", existing + Arrays.toString(orders));
                    }

                }
                System.out.println(httpSession.getId());
                System.out.println(httpSession.getAttribute("Products").toString());
            }
            if (orderType.equalsIgnoreCase("laptops")) {
                String orders = request.getParameter("order");
                HttpSession httpSession = request.getSession(false);
                System.out.println(httpSession.getId());
                System.out.println(orders);
            }

//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet DisplayCart</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet DisplayCart at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
