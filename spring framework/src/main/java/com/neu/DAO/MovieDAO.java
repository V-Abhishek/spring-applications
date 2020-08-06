/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.DAO;

import com.neu.edu.pojo.Movie;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Abhishek
 */
public class MovieDAO {

    private static final SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    private Session session = null;

    private Session getSession() {
        if (session == null || !session.isOpen()) {
            session = sf.openSession();
        }
        return session;
    }

    private void beginTransaction() {
        getSession().beginTransaction();
    }

    private void commit() {
        getSession().getTransaction().commit();;
    }

    private void close() {
        getSession().close();
    }

    private void rollbackTransaction() {
        getSession().getTransaction().rollback();
    }

    public int addMovie(String title, String actor, String actress, String genre, int year) {
        int result = 0;
        try {
            beginTransaction();
            Movie movie = new Movie();
            movie.setMovieName(title);
            movie.setActor(actor);
            movie.setActress(actress);
            movie.setGenre(genre);
            movie.setYear(year);
            getSession().save(movie);
            commit();
            result = 1;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            close();
        }
        return result;
    }

    public ArrayList<Movie> searchMovie(String keyword, String filter) {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        try {
            beginTransaction();
            Query q = null;
            if (filter.equalsIgnoreCase("title")) {
                q = getSession().createQuery("from Movie where title = :keyword");
            } else if (filter.equalsIgnoreCase("actor")) {
                q = getSession().createQuery("from Movie where actor = :keyword");
            } else {
                q = getSession().createQuery("from Movie where actress = :keyword");
            }
            q.setString("keyword", keyword);
            movies = (ArrayList<Movie>) q.list();
            commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return movies;
    }

    public int deleteMovie(String movieName) {
        int result = 0;
        try {
            beginTransaction();
            Query q = getSession().createQuery("from Movie where title = :movieName");
            q.setString("movieName", movieName);
            Movie movie = (Movie) q.uniqueResult();
            Query q2 = getSession().createQuery("from Movie where id = :id");
            q2.setInteger("id", movie.getId());
            Movie movieToDelete = (Movie) q2.uniqueResult();
            getSession().delete(movieToDelete);
            commit();
            result = 1;
        } catch (Exception e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return result;
    }

    public int updateMovie(int id, String title, String actor, String actress, String genre, int year) {
        int result = 0;
        try {
            beginTransaction();
            Query q = getSession().createQuery("from Movie where id = :id");
            q.setInteger("id", id);
            Movie movie = (Movie) q.uniqueResult();
            movie.setActor(actor);
            movie.setActress(actress);
            movie.setGenre(genre);
            movie.setYear(year);
            getSession().save(movie);
            commit();
            result = 1;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            close();
        }
        return result;
    }

}
