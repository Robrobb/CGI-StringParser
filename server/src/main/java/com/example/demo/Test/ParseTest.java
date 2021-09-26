package com.example.demo.Test;

import com.example.demo.Compute.Parser;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class ParseTest {
    @Test
    public void parserTest(){
        Parser parser = new Parser();
        String arg="Banan Äpple Katt hund Banan Hund Katt Hund";
        String expected="[hund:3, banan:2, katt:2, äpple:1]";
        String result=parser.getWordCount(arg).toString();
        assertEquals(expected,result);
    }
    @Test
    public void stringSplitTest(){
        Parser parser = new Parser();
        String arg=" Banan Äpple Katt hund ";
        String[] expected={"Banan","Äpple","Katt","hund"};
        String[] result=parser.getWordArray(arg);
        assertEquals(expected,result);
    }
     @Test
    public void wordPutTest(){
         Parser parser = new Parser();

         String[] arg={"Banan","Hund","Katt","hund"};
         Map<String,Integer> expected=new HashMap<>();
         expected.put("hund",2);
         expected.put("banan",1);
         expected.put("katt",1);

         Map<String,Integer> result=parser.countWords(arg);
         assertEquals(expected,result);
    }
    @Test
    public void testFinalStringConverter(){
        Parser parser = new Parser();
        List<Map.Entry<String,Integer>> list = new LinkedList<>();
        Map<String,Integer> tmpHashMap=new HashMap<>();
         tmpHashMap.put("hund",2);
        tmpHashMap.put("banan",1);
        tmpHashMap.put("katt",1);

        list=parser.getSortedLinkedList(tmpHashMap);
        List<String> result=parser.finalFormat(list);
        List<String> expected= new ArrayList<>();
        expected.add("hund:2");
        expected.add("banan:1");
        expected.add("katt:1");
        assertEquals(expected,result);
    }

}
