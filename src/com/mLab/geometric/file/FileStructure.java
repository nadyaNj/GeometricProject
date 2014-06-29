package com.mLab.geometric.file;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by aram on 6/29/14.
 */
public class FileStructure {
    int tabCounter = 0;

    public void listFilesAndFolders(String folder, SearchTypes type) {

        File file = new File(folder);
        isFileFolderExist(file);
        createHierarchy(file,type);


    }

    private String getTabs() {

        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < tabCounter; i++)
            buffer.append("\t");

        return buffer.toString();
    }


    private void isFileFolderExist(File file) {

        if (!file.exists() || !file.isDirectory()) {

            System.out.println("Parameter is not a directory");
            System.exit(1);

        }
    }

    private void createHierarchy(File file, SearchTypes searchType) {

        switch (searchType) {
            case  SEARCH_BY_NONE:searchAll(file);
            break;
            case  SEARCH_BY_NAME:searchFileByName(".doc",file);
            break;
            case SEARCH_BY_PATH:searchFileByPath(".doc", file);
                break;
            default: break;
        }


    }

    private void searchAll(File file) {
        File[] fileArray = file.listFiles();

        for (int i = 0; i < fileArray.length; i++) {

            if (fileArray[i].isDirectory()) {


                searchAll(new File(fileArray[i].getAbsolutePath()));
                System.out.println(getTabs() + "- " + fileArray[i].getName());
                tabCounter++;

            }
            else {

                System.out.println(getTabs() + fileArray[i].getName());
            }
        }
        tabCounter--;
    }

    private void searchFileByName(String fileName, File file) {
        File[] listOfFiles = file.listFiles();
        if(listOfFiles != null) {
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isDirectory()) {

                    System.out.println(getTabs() + "- " + listOfFiles[i].getName());
                    tabCounter++;
                    searchFileByName(fileName, new File(listOfFiles[i].getName()));


                } else {
                    if (listOfFiles[i].getName().contains(fileName)) {
                        System.out.println(getTabs() + listOfFiles[i].getName());
                    }
                }
            }
            tabCounter--;
        }

    }

    private void searchFileByPath(String path, File folder) {
        File[] listOfFiles = folder.listFiles();

        if(listOfFiles != null) {
            for (int i = 0; i < listOfFiles.length; i++) {
                ArrayList<File> fileArrayList = new ArrayList<File>();
                if (listOfFiles[i].isDirectory()) {

                    searchFileByPath(path, new File(listOfFiles[i].getName()));

                } else {
                    if (listOfFiles[i].getName().endsWith(path)) {
                        fileArrayList.add(new File(listOfFiles[i].getName()));
                        System.out.println(getTabs() + listOfFiles[i].getName());
                    }
                }
                if(fileArrayList.size() != 0) {
                    System.out.println(getTabs() + "- " + listOfFiles[i].getName());
                    tabCounter++;
                }
            }

        }
        if(tabCounter != 0) {
            tabCounter--;
        }

    }




}
