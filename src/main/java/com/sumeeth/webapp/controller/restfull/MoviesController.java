package com.sumeeth.webapp.controller.restfull;

import com.sumeeth.webapp.data.dto.Movies;
import com.sumeeth.webapp.service.MoviesService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("movies")
public class MoviesController {
    Logger log = Logger.getLogger(MoviesController.class);

    @Autowired
    private MoviesService moviesService;

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String test() {
        return "Welcome to Restfull webservice! ";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String error() {
        return "Welcome to Restfull webservice! ";
    }

    @RequestMapping(value = "/synch", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map synchMovies()
            throws Exception {
        Map<String, Object> map = new ModelMap();
        List<Movies> mList = moviesService
                .getAllMoviesByLimit(
                        getActualOffset(1, 10), 10);
        int rowsAffected = moviesService
                .synchMoviesFromLocalSytem();
        long totalRows = moviesService.getTotalMovies();
        map.put("page_title", "Movies Offline");
        map.put("moviesList", mList);
        map.put("fileType", "movies");
        map.put("rows_affected", rowsAffected);
        map.put("rows_count", totalRows / 10);
        map.put("rows_start", 1);
        map.put("rows_display", 10);
        return map;
    }

    @RequestMapping(value = "/showAll", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map getMusicFromDB() {
        Map<String, Object> map = new ModelMap();
        List<Movies> mList = null;
        mList = moviesService.getAllMoviesByLimit(
                getActualOffset(1, 10), 10);
        long total_rows = moviesService.getTotalMovies();
        log.debug(mList);
        map.put("page_title", "Movies Offline");
        map.put("moviesList", mList);
        map.put("fileType", "movies");
        map.put("rows_affected", mList.size());
        map.put("rows_count", total_rows / 10);
        map.put("rows_start", 1);
        map.put("rows_display", 10);
        return map;
    }

@RequestMapping(value = "/get/{total}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map getMusicFromDBWithUpperLimit(@PathVariable("total") String total){
    int limit=0;
    try {
         limit = Integer.parseInt(total);
    }catch (NumberFormatException e){
        log.info(e);
        limit=10;
    }
    log.info("limit :"+limit);
    Map<String, Object> map = new ModelMap();
    List<Movies> mList = null;
    mList = moviesService.getAllMoviesByUperLimit(limit);
    log.debug(mList);
    map.put("page_title", "Movies Offline");
    map.put("moviesList", mList);
    map.put("fileType", "movies");
    map.put("rows_affected", mList.size());
    map.put("rows_count", mList.size());
    map.put("rows_start", 1);
    map.put("rows_display", 10);
    return map;

}

    private int getActualOffset(int value, int limit) {

        int maxValue = value * limit;
        log.debug("actual Offset : " + (maxValue - limit));
        return maxValue - limit;

    }

}
