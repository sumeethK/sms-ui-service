package com.sumeeth.webapp.service;

import com.sumeeth.webapp.data.dto.Movies;

import java.util.List;

/**
 * @author sumeeth kumar kanojia
 *
 */
public interface MoviesService {

	List<Movies> getAllMovies();

	int synchMoviesFromLocalSytem() throws Exception;

	List<Movies> getMoviesByName(String name);

	void save(Movies dto) throws Exception;

	long getTotalMovies();

	void updateMoviesCategory(String newCategory, int id);

	Movies getMoviesById(int id);

    List<Movies> getAllMoviesByUpperLimit(int limit);

    List<Movies> getAllMoviesByLimitAndOffset(int limit, int offset);
}
