package org.example;

public class ColourTable {
    private int [][] colourTable;
    private int capacity;
    private int currentSize;

    //constructor for colour table
    public ColourTable(int capacity){
        if(!isValidCapacity(capacity)){
            throw new IllegalStateException("Invalid Capacity: " +capacity);
        }
        this.capacity=capacity;
        this.colourTable=new int[capacity][3];
        this.currentSize=0;

    }
    //method for getting capacity
    public int getCapacity(){
        return capacity;
    }

    public int add(int[] rgb) {
        if(!isValidRGB(rgb)){
            throw new ArrayIndexOutOfBoundsException("Invalid RGB value: " + rgb);
        }
        if (contains(rgb)){
            throw new IllegalStateException("RGB already in palette");

        }

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

    private boolean isValidRGB(int[] rgb) {
        if (rgb.length != 3) {
            return false;
        }
        // Check each value
        for (int value : rgb) {
            if (!(value >= 0 && value < 256)) {
                return false;
            }
        }

        return true;}

    private boolean isValidCapacity(int capacity){
        if(capacity>=2 &&capacity <=1025 && ((capacity & (capacity - 1)) == 0)){
            return true;
        }
        return false;
    }
    public int[] getRGBAtIndex(int index) {
        if (index<0&&index < currentSize) {
            return colourTable[index];
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }


}




