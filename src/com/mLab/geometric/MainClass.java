package com.mLab.geometric;

import com.mLab.geometric.model.enums.WorldSide;
import com.mLab.geometric.file.FileStructure;
import com.mLab.geometric.file.SearchTypes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nadya on 6/25/14.
 */
public class MainClass {
    public static void main(String[] args) {
        LinkedList<String> myLinkedList = new LinkedList<String>();
        for(int i = 0; i < 10; i ++) {
            myLinkedList.add("sdads " + i );
        }
        System.out.println(myLinkedList.toString());

        WorldSide east = WorldSide.EAST;
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

        Pattern pattern = Pattern.compile("#(\\w+).?\\1");

       myLinkedList.add(2, "dddd");
        System.out.println(myLinkedList.toString());

        FileStructure fileStructure = new FileStructure();
        fileStructure.listFilesAndFolders("/home/aram/", SearchTypes.SEARCH_BY_PATH);

    }
}
