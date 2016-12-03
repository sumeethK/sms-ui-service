package com.sumeeth.webapp.controller.restfull;

import com.sumeeth.webapp.data.dto.Movies;
import com.sumeeth.webapp.exception.Error;
import com.sumeeth.webapp.service.MoviesService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@CrossOrigin
@RestController
@RequestMapping("movies")
public class MoviesController {
    private Logger log = Logger.getLogger(MoviesController.class);

    @Resource
    Error moviesError;

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
        moviesError.setErrorCode("404");
        moviesError.setErrorDesc("Oops! Requested Resource Not Found.");
        return moviesError.toString();
    }

    @RequestMapping(value = "/synch", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map synchMovies()
            throws Exception {
        List<Movies> mList = moviesService
                .getAllMoviesByLimitAndOffset(
                        getActualOffset(1, 10), 10);
        int rowsAffected = moviesService
                .synchMoviesFromLocalSytem();
        long totalRows = moviesService.getTotalMovies();
     return  generateResultMap(mList,rowsAffected,totalRows);
    }

    @RequestMapping(value = "/showAll", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map getAllMovies() {
        Map<String, Object> map = new ModelMap();
        List<Movies> mList =  moviesService.getAllMoviesByLimitAndOffset(
                getActualOffset(1, 10), 10);
        long total_rows = moviesService.getTotalMovies();
        log.debug("getAllMovies: "+mList);
        return  generateResultMap(mList, ((int) total_rows),total_rows);
    }

@RequestMapping(value = "/get/{total}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map getSomeMovies(@PathVariable("total") String total){
    int limit=10;
    try {
         limit = Integer.parseInt(total);
    }catch (NumberFormatException e){
        log.info(e);
    }
    log.debug("getSomeMovies limit :"+limit);
    Map<String, Object> map = new ModelMap();
    List<Movies> mList =moviesService.getAllMoviesByUperLimit(limit);
    long total_rows = moviesService.getTotalMovies();
    return  generateResultMap(mList, ((int) total_rows),total_rows);

}

    @RequestMapping(value = "/get/{limit}/{offset}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map getMoviesLimitAndOffset(@PathVariable("limit") String limitParam,
                                       @PathVariable("offset") String offsetParam){
        int limit=10;
        int offset=0;
        try {
            limit = Integer.parseInt(limitParam);
            offset = Integer.parseInt(offsetParam);

        }catch (NumberFormatException e){
            log.info(e);
        }
        log.info("limit :"+limit);
        Map<String, Object> map = new ModelMap();
        List<Movies> mList = moviesService.getAllMoviesByLimitAndOffset(limit,offset);
        long total_rows = moviesService.getTotalMovies();
        return  generateResultMap(mList, ((int) total_rows),total_rows);

    }

    private Map<String, Object> generateResultMap(List<Movies> mList, int rowsAffected, long totalRows) {
        Map<String, Object> map = new ModelMap();

        map.put("page_title", "Movies Offline");
        map.put("moviesList", mList);
        map.put("fileType", "movies");
        map.put("rows_affected", rowsAffected);
        map.put("rows_count", totalRows / 10);
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
