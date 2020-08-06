/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.edu.controller;

import com.neu.DAO.MovieDAO;
import com.neu.edu.pojo.Movie;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Abhishek
 */
public class BeanMovieController extends AbstractController {

    public BeanMovieController() {
    }

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = null;
        try {
            String action = request.getParameter("action");
            if (action.equalsIgnoreCase("addition")) {
                String movie = request.getParameter("movieName");
                String actor = request.getParameter("actor");
                String actress = request.getParameter("actress");
                String genre = request.getParameter("genre");
                int year = Integer.parseInt(request.getParameter("year"));
                MovieDAO movieDAO = new MovieDAO();
                int result = movieDAO.addMovie(movie, actor, actress, genre, year);
                if (result == 1) {
                    String msg = "1 Movie has been added successfully";
                    mv = new ModelAndView("success", "message", msg);
                } else {
                    mv = new ModelAndView("error", "message", "Not able to add movie");
                }
            }
            if (action.equalsIgnoreCase("search")) {
                String keyword = request.getParameter("keyword");
                String filter = request.getParameter("choice");
                MovieDAO movieDAO = new MovieDAO();
                ArrayList<Movie> movieList = movieDAO.searchMovie(keyword, filter);
                request.setAttribute("searchword", keyword);
                mv = new ModelAndView("movie-results", "movieList", movieList);
            }
            if (action.equalsIgnoreCase("deletion")) {
                String title = request.getParameter("deleteMovie");
                MovieDAO movieDAO = new MovieDAO();
                int result = movieDAO.deleteMovie(title);
                if (result == 1) {
                    String msg = "1 Movie has been deleted successfully";
                    mv = new ModelAndView("success", "message", msg);
                } else {
                    mv = new ModelAndView("error", "message", "Movie not found");
                }
            }
            if (action.equals("updateSearch")) {
                String title = request.getParameter("updateSearchMovie");
                MovieDAO movieDAO = new MovieDAO();
                ArrayList<Movie> movieList = movieDAO.searchMovie(title, "title");
                if (movieList.size() == 1) {
                    request.setAttribute("searchword", title);
                    mv = new ModelAndView("update-results", "movieList", movieList);
                } else {
                    mv = new ModelAndView("error", "message", "Movie to be updated not found");
                }
            }
            if (action.equals("updation")) {
                String movie = request.getParameter("movieName");
                String actor = request.getParameter("actor");
                String actress = request.getParameter("actress");
                String genre = request.getParameter("genre");
                int year = Integer.parseInt(request.getParameter("year"));
                int id = Integer.parseInt(request.getParameter("id"));
                MovieDAO movieDAO = new MovieDAO();
                int result = movieDAO.updateMovie(id, movie, actor, actress, genre, year);
                if (result == 1) {
                    String msg = movie + " deatils have been updated successfully";
                    mv = new ModelAndView("success", "message", msg);
                } else {
                    String msg = "Movie can not be updated at this point of time";
                    mv = new ModelAndView("error", "message", msg);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return mv;
    }

}
