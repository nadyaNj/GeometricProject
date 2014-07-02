package com.mLab.geometric.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileStructure {

    private File root;

    public FileStructure(String rootPath) {
        this(new File(rootPath));

    }

    public FileStructure(File rootFile) {
        if(!rootFile.exists()){
            rootFile.mkdirs();
            rootFile.mkdir();
        }

        if(!rootFile.isDirectory()) {

        }
        this.root = rootFile;
    }

    public List<File> findAll() {
       return findInDirectory(root,SearchType.ANY,null);
   }
    public List<File> findByName(String name) {
        return findInDirectory(root,SearchType.NAME,name);
    }
    public List<File> findExtension(String extension) {
        return findInDirectory(root,SearchType.EXTENSION,extension);
    }

    public List<File> findExtensions(String[] extensions) {
        List<File> files = new ArrayList<File>();
        for(int i= 0; i < extensions.length; i ++ ) {
            files.addAll(findExtension(extensions[i]));
        }

        return files;
    }

    private List<File> findInDirectory(File dir,SearchType searchType,String part) {
        List<File> allFiles = new ArrayList<File>();
        for(File f : dir.listFiles()) {
            if(f.isFile()) {
                switch (searchType) {
                    case ANY:
                        allFiles.add(f);
                        break;
                    case EXTENSION:
                        if(f.getName().endsWith("."+part)) {
                            allFiles.add(f);
                        }
                        break;
                    case NAME:
                        if(f.getName().contains(part)) {
                            allFiles.add(f);
                        }
                        break;
                    default:break;
                }

            } else {
                allFiles.addAll(findInDirectory(f, searchType, part));
            }
        }
        return allFiles;
    }




}
