FIND LEAST RESISTANCE PATH

Tools and Software Used:
Android Studio,Gradle,Junit

Program Description:

Input:
Asks the user to input number of rows, columns and asks the user to enter the data in a single line with spaces.

Process of Execution:
Parses the data into two dimensional array with size rows*columns.
Checks for data validation and exits the execution if data is found to be invalid.

Each resistance is considered to be a node with properties as its location(x,y) in the grid,
resistance and total resistance in the path.

First the actual process starts as a kind of greedy algorithm
Starts for the element in (0,0) and from there it finds the neighbours.For every neighbour
it calculates the total resistance in its path.
Primary idea is to find the best path at each neighbour stage.

In course of execution, a node might be a neighbour to serveral nodes 
and there would be severeal toal resistances,but the least among all 
is considered to be the totalresistance in its path.

The process is repeated for Every neighbour of the first one and neighbours of neighbours 
and continues so on until we reach the last column.its stopped there.

So by now we got several neighboured paths from first column to last column
 and possible total resistance at every node.So we have to identify which one should be considered in each column
from first row to last row.

This is done by comparing the resistances in each column backwards starting at the last column and 
proceeeding to previous column neighbours of least total resistance node in current column.
In this way we continue and find a least resitance node in each column.
There by a least resistance path is formed from first column to last column

In course of time if the total resistance exceeds 50,execution stops there and prints path until there..


Tests(JUNIT):
The program is tested for invalid input and the three inputs given in the problem using JUNIT.
