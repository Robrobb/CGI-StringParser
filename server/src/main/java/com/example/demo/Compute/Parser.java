package com.example.demo.Compute;

import java.util.*;

public class Parser {
    public List<String> parse(String text) {

        Map<String, Integer> wordMap = new HashMap<>();

        String[] wordarray;

        List<String> finalArrayOutPut = new ArrayList<>();
        //for sizing list
        int resizer = 0;
        //for counting doubles
        int counter = 1;

        wordarray = text.split("[\\n\\s\\-\\.\\'\\?\\,\\_\\@()]+");

        Arrays.sort(wordarray);

        for (String word : wordarray) {
            String tmpWord = word;
            tmpWord = tmpWord.toLowerCase();
            if (wordMap.get(word) == null && word.toLowerCase().equals(tmpWord)) {
                counter = 1;
                wordMap.put(word, counter);
            } else {
                counter++;
                wordMap.replace(word, counter);
            }
        }
        //hashmap to linked list for easier sorting
        List<Map.Entry<String, Integer>> list = new LinkedList<>(wordMap.entrySet());
        list.sort(Map.Entry.comparingByValue());
        Collections.reverse(list);
        //linked list to simple string array for easier output and correct size
        for (Map.Entry tmpList : list) {
            resizer++;
            if (resizer < 11) {
                finalArrayOutPut.add(tmpList.getKey().toString() + ":" + tmpList.getValue().toString());
            }
        }
        return finalArrayOutPut;
    }
}
