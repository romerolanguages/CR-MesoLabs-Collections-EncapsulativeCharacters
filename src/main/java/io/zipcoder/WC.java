package io.zipcoder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.Map.Entry;

public class WC {

    private Iterator<String> si;
    private LinkedHashMap<String, Integer> linkedHashMap;
    private final String DELIMITER = "[^a-zA-Z0-9]+";

    public WC(String fileName) {
        try {
            this.si = new Scanner(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.out.println(fileName + " Does Not Exist");
            System.exit(-1);
        }
        linkedHashMap = new LinkedHashMap<String, Integer>();
    }

    public WC(Iterator<String> si) {
        this.si = si;
        linkedHashMap = new LinkedHashMap<String, Integer>();
    }

    public LinkedHashMap<String, Integer> getLinkedHashMap() {
        return linkedHashMap;
    }

    public void addWordsToLinkedHashMap() {
//        System.out.println("test");

        while(si.hasNext()) {
            String[] words = si.next().split(DELIMITER);
            for (String word : words) {
                if (linkedHashMap.get(word) == null) {
                    linkedHashMap.put(word, 1);
                } else {
                    linkedHashMap.put(word, linkedHashMap.get(word) + 1);
                }
            }
        }
    }

    public static void main(String[] args) {

        String inputExpression = "first second third fourth";
        WC wc = new WC(WC.class.getResource("/aeneid.txt").getFile());
        wc.addWordsToLinkedHashMap();
        wc.getLinkedHashMap();
        for (Map.Entry entry : wc.getLinkedHashMap().entrySet()) {
            System.out.println(entry.toString());
        }

    }
}
