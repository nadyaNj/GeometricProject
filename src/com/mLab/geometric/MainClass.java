package com.mLab.geometric;
import com.mLab.geometric.file.FileStructure;

import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainClass {
    public static void main(String[] args) {
        LinkedList<String> myLinkedList = new LinkedList<String>();
        for(int i = 0; i < 10; i ++) {
            myLinkedList.add("sdads " + i );
        }
        System.out.println(myLinkedList.toString());

        String email = "dkhsjdfh@fkhsf.am";
        String emailPatternStr="\\w+@\\w+\\.[a-zA-Z]{2,3}";// \p unicode
        Pattern emailPattern = Pattern.compile(emailPatternStr);

        Matcher matcher = emailPattern.matcher(email);
        System.out.println("" + matcher.find());
        System.out.println(email.matches(emailPatternStr));

        Pattern emailPattern1 = Pattern.compile("D((A)((B)C))");

        Matcher matcher1 = emailPattern1.matcher("DABC");

        if(matcher1.matches()) {
            for(int i = 0; i <= matcher1.groupCount(); i ++) {
                System.out.println(matcher1.group(i));
            }
        }

        Pattern newPath = Pattern.compile("#(\\w+)");
        Matcher matcher2 = newPath.matcher("#dkshfdj#kjfshskjfh#kfhskjfh#");

        while (matcher2.find()) {
            System.out.println(matcher2.group(0));
        }


       myLinkedList.add(2, "dddd");
        System.out.println(myLinkedList.toString());


        FileStructure fileStructure = new FileStructure("/home/nadya/IdeaProjects");
        List<File> all = fileStructure.findExtension("java");
        for(File f: all) {
            System.out.println(f.getAbsolutePath());
        }

    }
}
