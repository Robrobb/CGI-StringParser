package com.example.demo.Compute;

import java.util.*;

public class Parser {


    public List<String> getWordCount(String text){
        String[] wordArray=getWordArray(text);
        Map<String,Integer> wordMap=countWords(wordArray);
        List<Map.Entry<String,Integer>> linkedList=getSortedLinkedList(wordMap);
        return finalFormat(linkedList);
    }
    public String[] getWordArray(String text){
        return text.trim().split("[\\n\\s\\-\\.\\'\\?\\,\\_\\@()]+");
    }

    public Map<String,Integer> countWords(String[] wordArray){
        Map<String, Integer> wordMap = new HashMap<>();

        for (String word : wordArray) {

            word=word.toLowerCase();
            if (wordMap.get(word.toLowerCase()) == null) {

                wordMap.put(word, 1);
            } else {
               int counter=wordMap.get(word);
                wordMap.replace(word,counter+1);
            }
        }
        return wordMap;
    }

    public List<Map.Entry<String,Integer>> getSortedLinkedList(Map<String,Integer> wordMap) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(wordMap.entrySet());
        list.sort(Map.Entry.comparingByValue());
        Collections.reverse(list);
        return list;
    }

    public List<String> finalFormat(List<Map.Entry<String,Integer>> list) {
        int resizer=0;
        List<String> finalArrayOutPut = new ArrayList<>();
        for (Map.Entry tmpList : list) {
            resizer++;
            if (resizer < 11) {
                finalArrayOutPut.add(tmpList.getKey().toString() + ":" + tmpList.getValue().toString());
            }
        }
        return finalArrayOutPut;
    }


}

