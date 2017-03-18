package com.sumeeth.webapp.service;

import com.sumeeth.webapp.data.dao.MoviesDAO;
import com.sumeeth.webapp.data.dto.Movies;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sumeeth kumar kanojia
 */
@Service
public class MoviesServiceImpl implements MoviesService {


    @Resource
    MoviesDAO moviesDAO;

    @Override
    public List<Movies> getAllMovies() {
        return moviesDAO.getAllMovies();
    }


    @Override
    public int synchMoviesFromLocalSytem() throws Exception {
        return moviesDAO.synchMoviesFromLocalSytem();
    }

    @Override
    public List<Movies> getMoviesByName(String name) {
        return moviesDAO.getMoviesByName(name);
    }

    @Override
    public long getTotalMovies() {
        return moviesDAO.getTotalMovies();
    }

    @Override
    public void save(Movies dto) throws Exception {

    }

    @Override
    public void updateMoviesCategory(String newCategory,
                                     int id) {
        moviesDAO.updateMoviesCategory(newCategory, id);
    }

    @Override
    public Movies getMoviesById(int id) {
        return moviesDAO.getMoviesById(id);
    }

    @Override
    public List<Movies> getAllMoviesByUpperLimit(int limit) {
        return moviesDAO.getAllMoviesByUperLimit(limit);
    }

    @Override
    public List<Movies> getAllMoviesByLimitAndOffset(int limit,int offset) {
        return moviesDAO.getAllMoviesByLimitAndOffset(limit,offset);
    }

}
