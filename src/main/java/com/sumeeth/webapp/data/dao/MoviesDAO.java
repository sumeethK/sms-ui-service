package com.sumeeth.webapp.data.dao;

import com.sumeeth.webapp.data.dto.Movies;

import java.util.List;


/**
 * @author sumeeth kumar kanojia
 *
 */
public interface MoviesDAO {

	List<Movies> getAllMovies();

	int synchMoviesFromLocalSytem() throws Exception;

	List<Movies> getMoviesByName(String name);

	void save(Movies dto) throws Exception;

	void insert(Movies dto)
			throws Exception;

	List<Movies> getMoviesByAbsolutePath(String name);

	long getTotalMovies();

    List getAllAbsolutePaths();

    void updateMoviesCategory(String newCategory, int id);

	Movies getMoviesById(int id);

    List<Movies> getAllMoviesByUperLimit(int limit);

    List<Movies> getAllMoviesByLimitAndOffset(int limit, int offset);
}
