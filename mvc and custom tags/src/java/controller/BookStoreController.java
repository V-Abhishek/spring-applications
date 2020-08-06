/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BookDAO;

/**
 *
 * @author Abhishek
 */
public class BookStoreController extends HttpServlet {

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
        try {
            String action = request.getParameter("action");
            if (action.equalsIgnoreCase("addition") && !request.getParameter("numberOfBooks").equalsIgnoreCase("")) {
                System.out.println("Inside Add");
                String numberOfBooks = request.getParameter("numberOfBooks");
                request.setAttribute("numberOfBooks", numberOfBooks);
                RequestDispatcher rd = request.getRequestDispatcher("/view/addBook.jsp");
                rd.forward(request, response);
            }
            if (action.equalsIgnoreCase("DB")) {
                int books = Integer.parseInt(request.getParameter("valuesList"));
                BookDAO bookDAO = new BookDAO();
                int result = bookDAO.addBooks(books, request);
                if (result != 0) {
                    request.setAttribute("numberOfBooks", books);
                    RequestDispatcher rd = request.getRequestDispatcher("/view/shelf.jsp");
                    rd.forward(request, response);
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("/view/error.html");
                    rd.forward(request, response);
                }

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("/view/error.html");
            rd.forward(request, response);
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
