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

}