/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Abhishek
 */
public class ManageCart extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            String action = request.getParameter("action");
            if (action.equalsIgnoreCase("add")) {
                String[] cartItems = request.getParameterValues("items");
                HttpSession session = request.getSession(true);
                System.out.println(session.getId());
                ArrayList cartList = (ArrayList) session.getAttribute("cartList");
                if (cartList == null) {
                    cartList = new ArrayList();
                    session.setAttribute("cartList", cartList);
                }
                for (String c : cartItems) {
                    cartList.add(c);
                }
                System.out.println(Arrays.asList(cartList));
                RequestDispatcher rd = request.getRequestDispatcher("/shoppinglist.html");
                rd.forward(request, response);
            }
            if (action.equalsIgnoreCase("modify")) {
                String[] cartItems = request.getParameterValues("products");
                HttpSession session = request.getSession(false);
                System.out.println(session.getId());
                ArrayList cartList = (ArrayList) session.getAttribute("cartList");
                if (cartList != null) {
                    for (String c : cartItems) {
                        cartList.remove(c);
                    }
                }
                System.out.println(Arrays.asList(cartList));
                RequestDispatcher rd = request.getRequestDispatcher("/shoppinglist.html");
                rd.forward(request, response);
            }
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ManageCart</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ManageCart at " + request.getContextPath() + "</h1>");
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
