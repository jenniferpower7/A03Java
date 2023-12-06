package org.example;
/**
 * The ColourTable class represents a palette of RGB colours.
 * It allows storing and retrieving RGB values by index.
 */
public class ColourTable {

    // 2D array to store RGB values
    private final int[][] colourTable;

    // Capacity of the colour table
    private final int capacity;

    // Current size of the colour table
    private int currentSize;

    /**
     * Constructor for the ColourTable object.
     *
     * @param capacity The capacity of the colour table.
     * @throws IllegalStateException If the specified capacity is invalid.
     */
    public ColourTable(int capacity) {
        if (!isValidCapacity(capacity)) {
            throw new IllegalStateException("Invalid Capacity: " + capacity);
        }
        this.capacity = capacity;
        this.colourTable = new int[capacity][3];
        this.currentSize = 0;
    }

    /**
     * Gets the capacity of the colour table.
     *
     * @return The capacity of the colour table.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Adds a 24-bit RGB colour to the colour table.
     *
     * @param rgb The RGB values to be added.
     * @return The index at which the RGB values are added.
     * @throws ArrayIndexOutOfBoundsException If the RGB values are invalid.
     * @throws IllegalStateException        If the RGB values are already in the palette.
     */
    public int add(int[] rgb) {
        if (!isValidRGB(rgb)) {
            throw new ArrayIndexOutOfBoundsException("Invalid RGB value: " + rgb);
        }
        if (contains(rgb)) {
            throw new IllegalStateException("RGB already in palette");
        }

        for (int i = 0; i < 3; i++) {
            colourTable[currentSize][i] = rgb[i];
        }
        int index = currentSize;
        currentSize++;
        return index;
    }

    /**
     * Gets the current size of the colour table.
     *
     * @return The current size of the colour table.
     */
    public int getSize() {
        return currentSize;
    }

    /**
     * Checks if the colour table contains the specified RGB values.
     *
     * @param rgbColour The RGB values to check.
     * @return True if the colour table contains the RGB values, false otherwise.
     */
    public boolean contains(int[] rgbColour) {
        for (int[] colour : colourTable) {
            if (java.util.Arrays.equals(colour, rgbColour)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the given RGB values are valid.
     *
     * @param rgb The RGB values to check.
     * @return True if the RGB values are valid, false otherwise.
     */
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
        return true;
    }

    /**
     * Checks if the specified capacity is valid.
     *
     * @param capacity The capacity to check.
     * @return True if the capacity is valid, false otherwise.
     */
    private boolean isValidCapacity(int capacity) {
        return capacity >= 2 && capacity <= 1025 && ((capacity & (capacity - 1)) == 0);
    }

    /**
     * Gets the RGB values at the specified index.
     *
     * @param index The index to retrieve RGB values from.
     * @return The RGB values at the specified index.
     * @throws IndexOutOfBoundsException If the index is out of bounds.
     */
    public int[] getRGBAtIndex(int index) {
        if (index >= 0 && index < currentSize) {
            return colourTable[index];
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }
}
