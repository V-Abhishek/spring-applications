/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Abhishek
 */
public class BookDAO {

    public int addBooks(int books, HttpServletRequest request) {
        int result = 0;
        try {
            ConnectionDAO connectionDAO = new ConnectionDAO();
            Connection connection = connectionDAO.getConnection();
            String insert = "INSERT INTO booksdb.books (isbn,title,authors,price) values (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            for (int i = 1; i <= books; i++) {
                preparedStatement.setString(1, request.getParameter("isbn_" + i));
                preparedStatement.setString(2, request.getParameter("title_" + i));
                preparedStatement.setString(3, request.getParameter("authors_" + i));
                preparedStatement.setFloat(4, Float.parseFloat(request.getParameter("price_" + i)));
                result = preparedStatement.executeUpdate();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
