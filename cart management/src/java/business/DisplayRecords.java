/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Abhishek
 */
public class DisplayRecords extends HttpServlet {

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
            String fileName = request.getParameter("fileName").trim();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DisplayRecords</title>");
            out.println("</head>");
            out.println("<body>");
            if (!fileName.equalsIgnoreCase("")) {
                DriverConnection driverConnection = new DriverConnection();
                ResultSet results = driverConnection.connectAndRead(fileName);
                if (results != null) {
                    out.println("<h1>Result Records</h1>");
                    ResultSetMetaData rsmd = results.getMetaData();
                    int columnsNumber = results.getMetaData().getColumnCount();
                    while (results.next()) {
                        for (int i = 1; i <= columnsNumber; i++) {
                            if (i > 1) {
                                out.print(" || ");
                            }
                            String columnValue = results.getString(i);
                            out.print(rsmd.getColumnName(i) + " : " + columnValue);
                        }
                        out.println("<br>");
                    }
//                   out.println("<table BORDER=1 CELLPADDING=0 CELLSPACING=0%>"
//                            + "<tr><th>SalesOrderID</th><th>RevisionNumber</th></tr><th>OrderDate</th></tr><th>DueDate</th></tr><th>ShipDate</th></tr><th>Status</th></tr><th>OnlineOrderFlag</th></tr><th>SalesOrderNumber</th></tr><th>PurchaseOrderNumber</th></tr><th>AccountNumber</th></tr><th>CustomerID</th></tr><th>SalesPersonID</th></tr><th>TerritoryID</th></tr><th>BillToAddressID</th></tr><th>ShipToAddressID</th></tr><th>ShipMethodID</th></tr><th>CreditCardID</th></tr><th>CreditCardApprovalCode</th></tr><th>CurrencyRateID</th></tr><th>SubTotal</th></tr><th>TaxAmt</th></tr><th>Freight</th></tr><th>TotalDue</th></tr><th>Comment</th></tr><th>ModifiedDate</th></tr>");

//                    while (results.next()) {
//                        out.println("<tr><td><center>" + results.getString("SalesOrderID") + "</center></td>"
//                                + "<td><center>" + results.getString("RevisionNumber") + "</center></td></tr>" + "<td><center>" + results.getString("OrderDate") + "</center></td></tr>"+ "<td><center>" + results.getString("DueDate") + "</center></td></tr>"+ results.getString("ShipDate") + "</center></td></tr>"+ results.getString("Status") + "</center></td></tr>"+ results.getString("OnlineOrderFlag") + "</center></td></tr>"+ results.getString("SalesOrderNumber") + "</center></td></tr>"+ results.getString("PurchaseOrderNumber") + "</center></td></tr>"+ results.getString("AccountNumber") + "</center></td></tr>"+ results.getString("CustomerID") + "</center></td></tr>"+ results.getString("SalesPersonID") + "</center></td></tr>"+ results.getString("TerritoryID") + "</center></td></tr>"+ results.getString("BillToAddressID") + "</center></td></tr>"+ results.getString("ShipToAddressID") + "</center></td></tr>"+ results.getString("ShipMethodID") + "</center></td></tr>"+ results.getString("CreditCardID") + "</center></td></tr>"+ results.getString("CreditCardApprovalCode") + "</center></td></tr>"+ results.getString("CurrencyRateID") + "</center></td></tr>"+ results.getString("SubTotal") + "</center></td></tr>"+ results.getString("TaxAmt") + "</center></td></tr>"+ results.getString("Freight") + "</center></td></tr>"+ results.getString("TotalDue") + "</center></td></tr>"+ results.getString("Comment") + "</center></td></tr>"+ results.getString("ModifiedDate") + "</center></td></tr>");
//                    }
//                    out.println("</table>");
                }
            } else {
                out.println("<h1>No such file exist in the directory</h1>");
            }
            out.println("</body>");
            out.println("</html>");

        } catch (Exception e) {
            System.out.println(e.getMessage());
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
