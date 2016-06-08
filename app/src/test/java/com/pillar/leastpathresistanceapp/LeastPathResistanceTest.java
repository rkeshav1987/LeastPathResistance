package com.pillar.leastpathresistanceapp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by RishiS on 6/7/2016.
 */
public class LeastPathResistanceTest {

    @Test
    public void testInvalidData() {

        LeastPathResistance leastPathResistance = new LeastPathResistance();
        String data = "1 2 3 4 5 6";
        String result = leastPathResistance.printleastResistancePath(data, 5, 6);
        assertEquals("Invalid Data", result);
    }

    @Test
    public void test1(){
        LeastPathResistance leastPathResistance = new LeastPathResistance();
        String data="3 4 1 2 8 6 6 1 8 2 7 4 5 9 3 9 9 5 8 4 1 3 2 6 3 7 2 8 6 4";
        String result = leastPathResistance.printleastResistancePath(data, 5, 6);
        assertEquals("YES  16  1 2 3 4 4 5",result);
    }

    @Test
    public void test3(){
        LeastPathResistance leastPathResistance = new LeastPathResistance();
        String data="19 10 19 10 19 21 23 20 19 12 20 12 20 11 10";
        String result = leastPathResistance.printleastResistancePath(data, 3, 5);
        assertEquals("NO    1 1 1",result);
    }
}