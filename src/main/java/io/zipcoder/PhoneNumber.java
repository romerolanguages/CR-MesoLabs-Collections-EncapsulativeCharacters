package io.zipcoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumber {

    private Map<Character, char[]> map;
    private List<String> combos;

    public PhoneNumber() {
        this.map = new HashMap<Character, char[]>();
        initializeMap();
        this.combos = new ArrayList<>();
    }

    public Map<Character, char[]> getMap() {
        return map;
    }

    public List<String> getCombos() {
        return combos;
    }

    public void initializeMap() {
        map.put('0', new char[]{'0'});
        map.put('1', new char[]{'1'});
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
    }

    public void addIndexZeroOfEachCharArrayToCombos(String input) {
        char[] charArray = input.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char number = charArray[i];
            charArray[i] = map.get(number)[0];
        }
        combos.add(new String(charArray));
    }

    public void addNextElementsOfCharArrayToCombos(String input, int indexOfNumber) {
        char[] charArray = input.toCharArray();
        char number = charArray[indexOfNumber];
        if (input.length() > 1) {
            for (int i = 1; i < map.get(number).length; i++) {
                charArray[indexOfNumber] = map.get(number)[i];
                combos.add(new String(charArray));
            }
        }
    }

//    public String replaceCharsWithRecursion(String originalString, int index) {
//        char[] charArray = originalString.toCharArray();
//        char c = Character.toLowerCase(charArray[index]);
//        if (map.containsKey(c)) {
//            charArray[index] = map.get(c);
//        }
//        if (index < originalString.length() - 1) {
//            index++;
//            return replaceCharsWithRecursion(new String(charArray), index);
//        }
//        return new String(charArray);
//    }

    public static void main(String[] args) {
        String input = "4158239";
        String output = "g1jtadw";

        PhoneNumber pn = new PhoneNumber();
        pn.addIndexZeroOfEachCharArrayToCombos(input);
//        String allIndexZero = pn.getCombos().get(0);
        for (int i = 0; i < output.length(); i++) {
            pn.addNextElementsOfCharArrayToCombos(output, i);
        }
        System.out.println(pn.getCombos().toString());

//        pn.eachIndexOfLastCharArray(input);



    }
}
