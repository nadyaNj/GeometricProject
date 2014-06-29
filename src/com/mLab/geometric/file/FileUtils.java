package com.mLab.geometric.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by nadya on 6/27/14.
 */
public class FileUtils {
    public static String readFileContent(String path) {
        BufferedReader br = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {

            String sCurrentLine;
            br = new BufferedReader(new FileReader("MainClass.java"));


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return null;
        }
    }

    public static void writeToFile(String str) {

        File file = new File("");
        file.isDirectory();
        file.listFiles();
        file.getName();


    }

    public List<File> fildAll(String pattern) {
        // mp3|.mp4|.jpg|.png
        return null;
    }




}
