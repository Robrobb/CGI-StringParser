package com.example.demo.Test;

import com.example.demo.Compute.Parser;
import com.example.demo.Controllers.Controller;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = Controller.class)
public class ParseTest {
    @Test
    public void parserTest(){
        Parser parser = new Parser();
        String arg="Banan Äpple Katt hund Banan Hund Katt Hund";
        String expected="[Hund:3, Katt:2, Banan:2, Äpple:1]";
        String result=parser.getWordCount(arg).toString();
        assertEquals(expected,result);
    }
    @Test
    public void stringSplitTest(){
        Parser parser = new Parser();
        String arg=" Banan Äpple Katt Hund ";
        String[] expected={"Banan","Äpple","Katt","Hund"};
        String[] result=parser.getWordArray(arg);
        assertEquals(expected,result);
    }
     @Test
    public void wordPutTest(){
         Parser parser = new Parser();

         String[] arg={"Banan","Hund","Katt","Hund"};
         Map<String,Integer> expected=new HashMap<>();
         expected.put("Hund",2);
         expected.put("Banan",1);
         expected.put("Katt",1);

         Map<String,Integer> result=parser.countWords(arg);
         assertEquals(expected,result);
    }
    @Test
    public void testFinalStringConverter(){
        Parser parser = new Parser();
        List<Map.Entry<String,Integer>> list = new LinkedList<>();
        Map<String,Integer> tmpHashMap=new HashMap<>();
         tmpHashMap.put("Hund",2);
        tmpHashMap.put("Banan",1);
        tmpHashMap.put("Katt",1);

        list=parser.getSortedLinkedList(tmpHashMap);
        List<String> result=parser.finalFormat(list);
        List<String> expected= new ArrayList<>();
        expected.add("Hund:2");
        expected.add("Katt:1");
        expected.add("Banan:1");
        assertEquals(expected,result);
    }




}
