package com.pillar.leastpathresistanceapp;



import java.util.List;

public class Node {
	private int res;
	private int total_res;
	private int x;
	private int y;
	Node(int x, int y){
		total_res=200;
		this.x=x;
		this.y=y;
	}
	private List<Node> neighbours;
	public void setRes(int res){
		this.res=res;
		
	}
	public int getRes(){
		return this.res;
		
	}
	public void setTotalRes(int total_res){
		this.total_res=total_res;
			
		
	}
	public int getTotalRes(){
		return this.total_res;
	}
	public int getX(){
		return this.x;
	}
   public int getY(){
	return this.y;
}
   public void setNeighbours(List<Node> neighbs){
	   this.neighbours=neighbs;
	   
   }
   public List<Node> getNeighbs(){
	   return this.neighbours;
   }
}
