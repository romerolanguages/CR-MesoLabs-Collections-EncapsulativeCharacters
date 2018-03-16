package io.zipcoder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
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
        while(si.hasNext()) {
            String[] words = si.next().split(DELIMITER);
            for (String word : words) {
                word = word.toLowerCase();
                if (linkedHashMap.get(word) == null) {
                    linkedHashMap.put(word, 1);
                } else {
                    linkedHashMap.put(word, linkedHashMap.get(word) + 1);
                }
            }
        }
    }

    public String getWordCountInDescendingOrder() {
        List<Entry<String, Integer>> wordCount = new ArrayList<>(linkedHashMap.entrySet());
        StringBuilder sb = new StringBuilder();

        Collections.sort(wordCount, new Comparator<Entry>() {
            public int compare(Entry e1, Entry e2) {
                if ( (int)e2.getValue() == (int)e1.getValue() ) {
                    return 0;
                } else if ( (int)e1.getValue() > (int)e2.getValue() ) {
                    return -1;
                } else
                    return 1;
            }
        });

        sb.append("Count = Word" + "\n");
        for (Entry entry : wordCount) {
            sb.append(entry.getValue() + " = " + entry.getKey() + "\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        String inputExpression = "first second third fourth";
        WC wc = new WC(WC.class.getResource("/aeneid.txt").getFile());
        wc.addWordsToLinkedHashMap();
        wc.getLinkedHashMap();
//        for (Entry entry : wc.getLinkedHashMap().entrySet()) {
//            System.out.println(entry.toString());
//        }

        System.out.println(wc.getWordCountInDescendingOrder());

    }
}
