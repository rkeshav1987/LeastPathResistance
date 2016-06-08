package com.pillar.leastpathresistanceapp;

/**
 * Created by RishiS on 6/7/2016.
 */
public class LeastPathResistance {

    private int noOfRows;
    private int noOfColumns;
    private int[] inputData;
    final String INVALID_DATA="Invalid Data";

    public void inputRow(int rows){

        if(rows<0)
            return;
        else
            this.noOfRows=rows;
    }

    public String printleastResistancePath(String data, int rows, int columns) {

        int noOfrows = rows;
        int noOfColumns = columns;
        boolean maxResReached = false;
        String finalLeastPathString = "";
        String b[] = data.split("\\s+");
        int resRowCol[][] = new int[noOfrows][noOfColumns];

        if (b.length != noOfrows * noOfColumns) {
            System.out.println("Invalid data");
            return "Invalid Data";
        }

        int k = 0;
        for (int i = 0; i < noOfrows; i++) {
            for (int j = 0; j < noOfColumns; j++) {
                resRowCol[i][j] = Integer.parseInt(b[k]);
                k++;
                if (k > (noOfrows * noOfColumns)) {
                    System.out.println("Invalid data");
                    return "Invalid Data";
                }
            }
        }

        return INVALID_DATA;
    }
}
