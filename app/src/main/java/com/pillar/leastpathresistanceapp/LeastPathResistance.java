package com.pillar.leastpathresistanceapp;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Created by RishiS on 6/7/2016.
 */
public class LeastPathResistance {

    final String INVALID_DATA = "Invalid Data";

    public String printleastResistancePath(String data, int rows, int columns) {

        int noOfrows = rows;
        int noOfColumns = columns;
        boolean maxResReached = false;
        String finalLeastPathString = "";
        String b[] = data.split("\\s+");
        int resRowCol[][] = new int[noOfrows][noOfColumns];

        if (b.length != noOfrows * noOfColumns) {
            return INVALID_DATA;
        }

        int k = 0;
        for (int i = 0; i < noOfrows; i++) {
            for (int j = 0; j < noOfColumns; j++) {
                resRowCol[i][j] = Integer.parseInt(b[k]);
                k++;
                if (k > (noOfrows * noOfColumns)) {
                    return INVALID_DATA;
                }
            }
        }

        Map<Integer, Node> nodeMap = new HashMap<Integer, Node>();

        Queue<Node> nodesQueue = new ArrayDeque<Node>();

        int x = 0;
        int y = 0;

/*
 * Each node is a resistance point
 */

        Node node = new Node(x, y);

        node.setRes(resRowCol[x][y]);
        node.setTotalRes(resRowCol[x][y]);

        if (node.getTotalRes() >= 50) {
            System.exit(0);
        }

/*
 * This is a function to generate a unique number from the row and column numbers
 * of the matrix(two dimensional array resistances) so that
 * it can be used a queue to the hash map to store the nodes
 */
        int uniqueNum = (x + y) * (x + y + 1) + y;

        nodeMap.put(uniqueNum, node);

/*
 *Adding every neighbour of each node to the queue and then popped out to process
 *In this way we can get a track of neighbours from the beginning to end
 *
 */
        nodesQueue.add(node);


        while (!nodesQueue.isEmpty()) {

            Node currNode = nodesQueue.peek();

            x = currNode.getX();
            y = currNode.getY();

            if (y == (noOfColumns - 1)) {
                break;
            }

            int x1 = (x - 1) % noOfrows;
            if (x1 == -1) {
                x1 = (noOfrows - 1);
            }

            int x2 = (x) % noOfrows;

            int x3 = (x + 1) % noOfrows;

            if (x3 == noOfrows) {
                x3 = 0;
            }

            int y1 = y + 1;
            int y2 = y + 1;
            int y3 = y + 1;

            int uniqueNum1 = (x1 + y1) * (x1 + y1 + 1) + y1;
            int uniqueNum2 = (x2 + y2) * (x2 + y2 + 1) + y2;
            int uniqueNum3 = (x3 + y3) * (x3 + y3 + 1) + y3;
            /*
             * node1,node2 and node3 are the neighbours of the current node that is
			 * being processed.
			 */
            Node node1 = nodeMap.get(uniqueNum1);

            if (node1 == null) {

                node1 = new Node(x1, y1);

            }

            node1.setRes(resRowCol[x1][y1]);

            if (node1.getTotalRes() > currNode.getTotalRes() + node1.getRes()) {
                node1.setTotalRes(currNode.getTotalRes() + node1.getRes());
                nodeMap.put(uniqueNum1, node1);
            }

            Node node2 = nodeMap.get(uniqueNum2);

            if (node2 == null) {
                node2 = new Node(x2, y2);

            }

            node2.setRes(resRowCol[x2][y2]);

            if (node2.getTotalRes() > currNode.getTotalRes() + node2.getRes()) {
                node2.setTotalRes(currNode.getTotalRes() + node2.getRes());
                nodeMap.put(uniqueNum2, node2);
            }

            Node node3 = nodeMap.get(uniqueNum3);

            if (node3 == null) {
                node3 = new Node(x3, y3);

            }

            node3.setRes(resRowCol[x3][y3]);

            if (node3.getTotalRes() > currNode.getTotalRes() + node3.getRes()) {
                node3.setTotalRes(currNode.getTotalRes() + node3.getRes());
                nodeMap.put(uniqueNum3, node3);
            }
            if (node1.getTotalRes() >= 50 && node2.getTotalRes() >= 50 && node3.getTotalRes() >= 50) {
                maxResReached = true;
                noOfColumns = y1 + 1;
            }

            List<Node> neighboursList = new ArrayList<Node>();
            neighboursList.add(node1);
            neighboursList.add(node2);
            neighboursList.add(node3);

            currNode.setNeighbours(neighboursList);

            nodesQueue.add(node1);
            nodesQueue.add(node2);
            nodesQueue.add(node3);

            nodesQueue.remove();
        }

/*
 * By this point every node that might be in the path
 * has their minimum total resistance values in their path
 */


        int pos = -1;
        int tempres = 200;
        int finalPathRes = 0;
/*
 * Now starting to process from the last column
 * node with least toal res in last column will be the last
 * one in the desired path.We start from that and go back until the first row
 * to get desired path in each column
 *
 */
        for (int i = 0; i < noOfrows; i++) {
            int tempUnique2 = (i + (noOfColumns - 1)) * (i + (noOfColumns - 1) + 1) + (noOfColumns - 1);
            int tempres1 = nodeMap.get(tempUnique2).getTotalRes();
            if (tempres1 < tempres) {
                tempres = tempres1;
                pos = i;
            }
        }
        int tempUnique222 = (pos + (noOfColumns - 1)) * (pos + (noOfColumns - 1) + 1) + (noOfColumns - 1);

        List<Node> nodesinResultPath = new ArrayList<Node>();

        Node currnode = nodeMap.get(tempUnique222);
        finalPathRes = currnode.getTotalRes();
        nodesinResultPath.add(currnode);
        while (currnode.getY() != 0) {

            int posy = currnode.getY();
            int posx = currnode.getX();
            int y11 = posy - 1;
            int y22 = posy - 1;
            int y33 = posy - 1;

            int x11 = (posx - 1) % noOfrows;
            int x22 = (posx) % noOfrows;
            int x33 = (posx + 1) % noOfrows;

            int tempUnique11 = (x11 + y11) * (x11 + y11 + 1) + y11;
            int tempUnique22 = (x22 + y11) * (x22 + y22 + 1) + y22;
            int tempUnique33 = (x33 + y11) * (x33 + y33 + 1) + y33;

            Node node11 = nodeMap.get(tempUnique11);
            Node node22 = nodeMap.get(tempUnique22);
            Node node33 = nodeMap.get(tempUnique33);

            List<Node> consideredNodesInPath = new ArrayList<Node>();

            if (node11 != null) {
                consideredNodesInPath.add(node11);
            }
            if (node22 != null) {
                consideredNodesInPath.add(node22);
            }
            if (node33 != null) {
                consideredNodesInPath.add(node33);
            }

            int totalres11 = 200;

            for (Node eachNeighbourNodeBackwards : consideredNodesInPath)
                if (eachNeighbourNodeBackwards.getTotalRes() < totalres11) {
                    currnode = eachNeighbourNodeBackwards;
                    totalres11 = currnode.getTotalRes();

                }
            nodesinResultPath.add(currnode);
        }
        String yesNo = "";
        if (maxResReached == false) {
            yesNo = "YES";
        } else {
            yesNo = "NO";
        }
        finalLeastPathString = "" + yesNo + " " + " " + finalPathRes + " ";

        Collections.reverse(nodesinResultPath);

        for (Node node111 : nodesinResultPath) {
            finalLeastPathString = finalLeastPathString + " " + (node111.getX() + 1);
        }
        return finalLeastPathString;
    }
}
