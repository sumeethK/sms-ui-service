/**
 * 
 */
package com.sumeeth.webapp.data.dao;

import java.util.List;

import com.sumeeth.webapp.data.dto.Movies;


/**
 * @author sumeeth kumar kanojia
 *
 */
public interface MoviesDAO {

	List<Movies> getAllMovies();

	List<Movies> getAllMoviesByLimit(int offSet, int limit);

	int synchMoviesFromLocalSytem() throws Exception;

	List<Movies> getMoviesByName(String name);

	void save(Movies dto) throws Exception;

	abstract void insert(Movies dto)
			throws Exception;

	List<Movies> getMoviesByAbsolutePath(String name);

	long getTotalMovies();

    List<String> getAllAbsolutePaths();

    void updateMoviesCategory(String newCategory, int id);

	Movies getMoviesById(int id);

    List<Movies> getAllMoviesByUperLimit(int limit);
}
