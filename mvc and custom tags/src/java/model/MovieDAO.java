/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Abhishek
 */
public class MovieDAO {

    public void addMovie(String movie, String actor, String actress, String genre, int year) {
        System.out.println("Inside add");
        DAO dao = new DAO();
        try {
            Connection connection = dao.getConnection();
            System.out.println("Connection "+connection);
            String insert = "INSERT INTO moviedb.movies " + "(title,actor,actress,genre,year)" + "values ('" + movie + "'," + "'" + actor + "', " + "'" + actress + "', " + "'" + genre + "', " + "'" + year + "')";
            Statement statement = connection.createStatement();
            statement.execute(insert);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Movie> searchMovie(String keyword, String filter) {
        DAO dao = new DAO();
        System.out.println("Inside Search");
        try {
            Connection connection = dao.getConnection();
            String search = "SELECT * FROM moviedb.movies WHERE " + filter + " = '" + keyword + "'";
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(search);
            if (results != null) {
                ArrayList<Movie> movieList = new ArrayList<Movie>();
                while (results.next()) {
                    Movie movie = new Movie();
                    movie.setMovieName(results.getString("title"));
                    movie.setActor(results.getString("actor"));
                    movie.setActress(results.getString("actress"));
                    movie.setGenre(results.getString("genre"));
                    movie.setYear(results.getInt("year"));
                    movieList.add(movie);
                }
                return movieList;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
