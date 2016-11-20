package com.sumeeth.webapp.data.dao;

import com.sumeeth.webapp.data.dto.Movies;
import com.sumeeth.webapp.util.DirectoryScanner;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MoviesDAOImpl implements MoviesDAO {
    private EntityManagerFactory emf;
    private Logger log = Logger.getLogger(MoviesDAO.class);
    @Value("${application.movies.bas.dir?: D:/MOVIES}")
    private String MOVIES_BASE_DIR;

    @PersistenceUnit
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<Movies> getAllMovies() {
        EntityManager em = emf.createEntityManager();
        List<Movies> moviesList = em.createQuery("from Movies", Movies.class).getResultList();
        em.close();
        return moviesList;
    }


    @Override
    public int synchMoviesFromLocalSytem() throws Exception {
        File dir = new File(MOVIES_BASE_DIR);
        log.info("Loading movies from :" + MOVIES_BASE_DIR);
        List<Movies> moviesListFromLocalSystem = DirectoryScanner
                .getMoviesFromLocal(dir);
        List<Movies> moviesToBeInserted = new ArrayList<>();
        List<String> moviesPathFromDB = getAllAbsolutePaths();
        if (moviesListFromLocalSystem != null && !moviesListFromLocalSystem.isEmpty())

            //if database is empty then add all movies
            if (moviesPathFromDB == null) {
                moviesToBeInserted.addAll(moviesListFromLocalSystem);
            } else {
                //add all movies whose path doesn't exist in database
                for (Movies m : moviesListFromLocalSystem) {
                    if (!moviesPathFromDB.contains(m.getAbsolutePath())) {
                        moviesToBeInserted.add(m);
                    }

                }
            }
        try {
            log.debug("Total Movies to be Synched :" + moviesToBeInserted.size());
            insert(moviesToBeInserted);
            log.debug("Total Movies Synched :" + moviesToBeInserted.size());
            return moviesToBeInserted.size();
        } catch (
                Exception e
                ) {
            log.debug(e);
        }

        return 0;

    }

    private void insert(List<Movies> moviesToBeInserted) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        moviesToBeInserted.forEach(movie -> {
            em.persist(movie);
        });
        em.getTransaction().commit();
        em.close();
    }


    @Override
    public List<Movies> getMoviesByName(String name) {
        return null;
    }

    @Override
    public void save(Movies dto) throws Exception {

    }

    @Override
    public void insert(Movies dto)
            throws Exception {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(dto);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Movies> getMoviesByAbsolutePath(String path) {
        EntityManager em = emf.createEntityManager();

        List<Movies> moviesList = em.createQuery("from Movies m where m.absolutePath=:arg1", Movies.class)
                .setParameter("arg1", path)
                .getResultList();
        em.close();
        return moviesList;


    }

    @Override
    public long getTotalMovies() {
        EntityManager em = emf.createEntityManager();
        String jhql = "select count(m.id) FROM  Movies m";
        long total = (long) em.createQuery(jhql).getSingleResult();
        em.close();
        return total;
    }


    @Override
    public List<String> getAllAbsolutePaths() {
        EntityManager em = emf.createEntityManager();
        String jhql = "select m.absolutePath FROM  Movies m";
        List resultList = em.createQuery(jhql).getResultList();
        em.close();
        return resultList;
    }

    @Override
    public void updateMoviesCategory(String newCategory,
                                     int id) {

    }

    @Override
    public Movies getMoviesById(int id) {
        return null;
    }

    @Override
    public List<Movies> getAllMoviesByUperLimit(int limit) {
        EntityManager em = emf.createEntityManager();
        List<Movies> moviesList = em.createQuery("from Movies ", Movies.class)
                .setMaxResults(limit).getResultList();
        em.close();
        return moviesList;
    }

    @Override
    public List<Movies> getAllMoviesByLimitAndOffset(int limit, int offset) {
        EntityManager em = emf.createEntityManager();
        List<Movies> moviesList = em.createQuery("from Movies ", Movies.class)
                .setFirstResult(offset)
                .setMaxResults(limit).getResultList();
        em.close();
        return moviesList;
    }


}
