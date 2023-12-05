package org.example;

public class ColourTable {
    private int [][] colourTable;
    private int capacity;
    private int currentSize;

    //constructor for colour table
    public ColourTable(int capacity){
        this.capacity=capacity;
        this.colourTable=new int[capacity][3];
        this.currentSize=0;

    }
    //method for getting capacity
    public int getCapacity(){
        return capacity;
    }

    public int add(int[] rgb) {
        for (int i = 0; i < 3; i++) {
            colourTable[currentSize][i] = rgb[i];
        }
        int index = currentSize;
        currentSize++;
        return index;
    }

    public int getSize(){
        return currentSize;
    }

    public boolean contains(int[] rgbColour){
        for(int[] colour:colourTable){
            if (java.util.Arrays.equals(colour, rgbColour)){
                return true;
            }
        }
        return false;
    }

    }




