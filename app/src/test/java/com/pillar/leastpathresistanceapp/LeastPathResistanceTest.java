package com.pillar.leastpathresistanceapp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by RishiS on 6/7/2016.
 */
public class LeastPathResistanceTest {

    LeastPathResistance leastPathResistance = new LeastPathResistance();
    String data="";
    String result="";

    @Test
    public void testInvalidData() {
        data = "1 2 3 4 5 6";
        result = leastPathResistance.printleastResistancePath(data, 5, 6);
        assertEquals("Invalid Data", result);
    }

    @Test
    public void test1(){
        data="3 4 1 2 8 6 6 1 8 2 7 4 5 9 3 9 9 5 8 4 1 3 2 6 3 7 2 8 6 4";
        result = leastPathResistance.printleastResistancePath(data, 5, 6);
        assertEquals("YES  16  1 2 3 4 4 5",result);
    }

    @Test
    public void test2(){
        data="3 4 1 2 8 6 6 1 8 2 7 4 5 9 3 9 9 5 8 4 1 3 2 6 3 7 2 1 2 3";
        result = leastPathResistance.printleastResistancePath(data, 5, 6);
        assertEquals(result,"YES  11  1 2 1 5 4 5");
    }

    @Test
    public void test3(){
        data="19 10 19 10 19 21 23 20 19 12 20 12 20 11 10";
        result = leastPathResistance.printleastResistancePath(data, 3, 5);
        assertEquals("NO  48  1 1 1",result);
    }
}