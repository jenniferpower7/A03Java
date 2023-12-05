package org.example;

public class ColourTable {
    private int [][] colourTable;
    private int capacity;

    //constructor for colour table
    public ColourTable(int capacity){
        this.capacity=capacity;
        this.colourTable=new int[capacity][3];

    }
    //method for getting capacity
    public int getCapacity(){
        return capacity;
    }
}