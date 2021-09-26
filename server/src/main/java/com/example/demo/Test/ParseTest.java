package com.example.demo.Test;

import com.example.demo.Compute.Parser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParseTest {
    @Test
    public void parserTest(){
        Parser parser = new Parser();
        String a="Banan Äpple Katt Hund Banan Hund Katt Hund";
        String b="[Hund:3, Katt:2, Banan:2, Äpple:1]";
        assertEquals(b,parser.parse(a).toString());
    }

}
