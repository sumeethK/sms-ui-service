package com.sumeeth.webapp.util;

import com.sumeeth.webapp.data.dto.FileInfo;
import com.sumeeth.webapp.data.dto.FileInfoList;
import com.sumeeth.webapp.data.dto.Movies;
import com.sumeeth.webapp.exception.FileException;
import com.sumeeth.webapp.helper.MoviesBuilder;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.*;


/**
 * @author sumeeth kumar kanojia
 */
public class DirectoryScanner {
    private static final Logger logger = Logger
            .getLogger(DirectoryScanner.class);

    private DirectoryScanner() {
    }

    public static int numberOfFiles(File dir) {
        int count = 0;
        File[] list = dir.listFiles();
        assert list != null;
        for (File file : list)
            count = file.isFile() ? ++count : count;

        return count;
    }

    public static int numberOfDir(File dir) {
        int count = 0;
        File[] list = dir.listFiles();
        assert list != null;
        for (File file : list)
            count = file.isDirectory() ? ++count : count;

        return count;
    }

    public static int numberOfFilesOrDir(File dir) {
        int count = 0;
        File[] list = dir.listFiles();
        assert list != null;
        for (File file : list)
            count = file.isFile() ? ++count : file
                    .isDirectory() ? ++count : count;

        return count;
    }

    public static FileInfoList listAllFiles(File dir) {
        logger.info("Method Name : listAllFiles");
        FileInfoList fl = new FileInfoList();
        List<FileInfo> fileInfoList = new ArrayList<FileInfo>();
        List<File> filesList = (List<File>) FileUtils
                .listFiles(dir, null, true);
        for (File file : filesList) {
            FileInfo fInfo = new FIleInfoBuilder()
                    .withName(file.getName())
                    .withAbsolutePath(
                            file.getAbsolutePath())
                    .withCategory("default category")
                    .withModifiedDate(
                            getDate(file.lastModified()))
                    .withSize(file.length()).build();
            fileInfoList.add(fInfo);
            if (logger.isDebugEnabled()) {
                logger.debug(fInfo);
            }

        }
        fl.setFileInfoList(fileInfoList);
        logger.info("File Size  : " + fileInfoList.size());
        return fl;

    }

    public static FileInfoList listAllFilesWithExtension(
            File dir, String[] extensions) throws FileException {
        logger.info("Method Name : listAllFilesWithExtension");
        FileInfoList fl = new FileInfoList();
        boolean exit = extensions == null || extensions.length < 1;
        if (exit) {
            logger.debug("File Extension is null. Exit...");
            return null;
        }
        List<FileInfo> fileInfoList = new ArrayList<FileInfo>();
        try {
            logger.debug("Searching Files with ext :"
                    + getAllExtentions(extensions));
            List<File> filesList = (List<File>) FileUtils
                    .listFiles(dir, extensions, true);
            for (File file : filesList) {
                FileInfo fInfo = new FIleInfoBuilder()
                        .withName(file.getName())
                        .withAbsolutePath(
                                file.getAbsolutePath())
                        .withCategory("default category")
                        .withModifiedDate(
                                getDate(file.lastModified()))
                        .withSize(file.length()).build();
                fileInfoList.add(fInfo);
                if (logger.isDebugEnabled()) {
                    logger.debug(fInfo);
                }
            }
        } catch (Exception e) {
            throw new FileException(e.getMessage());
        }
        fl.setFileInfoList(fileInfoList);
        logger.info("File Size  : " + fileInfoList.size());
        return fl;
    }

   /* public static MusicList getMusicFromLocal(File dir) {
        String[] extensions = {"mp3"};
        logger.info("Method Name : listAllFilesWithExtension");
        MusicList fl = new MusicList();
        List<Music> musicInfoList = new ArrayList<Music>();
        try {
            logger.debug("Searching Files with ext :"
                    + getAllExtentions(extensions));
            List<File> filesList = (List<File>) FileUtils
                    .listFiles(dir, extensions, true);
            for (File file : filesList) {
                Music fInfo = new MusicBuilder()
                        .withName(file.getName())
                        .withAbsolutePath(
                                file.getAbsolutePath())
                        .withCategory("default category")
                        .withModifiedDate(
                                getDate(file.lastModified()))
                        .withSize(file.length()).build();
                musicInfoList.add(fInfo);
                if (logger.isDebugEnabled()) {
                    logger.debug(fInfo);
                }
            }
        } catch (Exception e) {
            new FileException(e.getMessage());
        }
        fl.setMusicInfoList(musicInfoList);
        logger.info("File Size  : " + musicInfoList.size());
        return fl;
    }
*/
    public static List<Movies> getMoviesFromLocal(File dir) throws FileException {
        String[] extensions = {"mp4", "avi", "mkv"};
        logger.info("Method Name : listAllFilesWithExtension");
        List<Movies> mList = new ArrayList<Movies>();
        try {
            logger.debug("Searching Files with ext :"
                    + getAllExtentions(extensions));
            List<File> filesList = (List<File>) FileUtils
                    .listFiles(dir, extensions, true);
            for (File file : filesList) {
                Movies fInfo = new MoviesBuilder()
                        .withName(file.getName())
                        .withAbsolutePath(
                                file.getAbsolutePath())
                        .withCategory("default category")
                        .withModifiedDate(
                                getDate(file.lastModified()))
                        .withSize(file.length()).build();
                mList.add(fInfo);
                if (logger.isDebugEnabled()) {
                    logger.debug(fInfo);
                }
            }
        } catch (Exception e) {
            throw new FileException(e.getMessage());
        }
        logger.info("File Size  : " + mList.size());
        return mList;
    }

    public static Date getDate(long milliseconds) {
        GregorianCalendar calendar = new GregorianCalendar(
                TimeZone.getDefault());
        calendar.setTimeInMillis(milliseconds);
        return calendar.getTime();

    }

    private static String getAllExtentions(
            String[] extensions) {
        String extensionsAsString = "";

        for (String ext : extensions) {
            extensionsAsString += ext + ",";

        }
        return extensionsAsString.substring(0,
                extensionsAsString.length() - 1);
    }

}
