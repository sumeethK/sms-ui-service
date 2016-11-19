/**
 * 
 */
package com.sumeeth.webapp.service;

import java.util.List;

import com.sumeeth.webapp.data.dto.Movies;

/**
 * @author sumeeth kumar kanojia
 *
 */
public interface MoviesService {

	List<Movies> getAllMovies();

	int synchMoviesFromLocalSytem() throws Exception;

	List<Movies> getMoviesByName(String name);

	void save(Movies dto) throws Exception;

	List<Movies> getAllMoviesByLimit(int offSet, int limit);

	long getTotalMovies();

	void updateMoviesCategory(String newCategory, int id);

	Movies getMoviesById(int id);

    List<Movies> getAllMoviesByUperLimit(int limit);
}
