package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the ColourTable class, implementing various test methods.
 */
public class ColourTableTest {

    @Test
    // Test that the constructor creates a palette of the size of the parameter
    public void testConstructorMethod() {
        ColourTable colourTable = new ColourTable(4);
        assertEquals(4, colourTable.getCapacity());
    }

    @Test
    // Test the add method to ensure correct functionality
    public void testAddMethod() {
        ColourTable colourTable = new ColourTable(4);
        int initialSize = colourTable.getSize();
        int[] rgbColourToAdd = {255, 0, 0};
        int index = colourTable.add(rgbColourToAdd);

        assertEquals(initialSize + 1, colourTable.getSize());
        assertTrue(colourTable.contains(rgbColourToAdd));
        assertEquals(0, index);
    }

    @Test
    // Test whether an exception is thrown when an invalid RGB is added to ColourTable
    public void testInvalidRGBExceeding() {
        ColourTable colourTable = new ColourTable(4);
        int[] invalidRGBValue = {0, 0, 256};
        ArrayIndexOutOfBoundsException exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            colourTable.add(invalidRGBValue);
        });

        // Check correct exception message is thrown
        assertEquals("Invalid RGB value: " + invalidRGBValue, exception.getMessage());
    }

    @Test
    // Test whether an exception is thrown when an invalid RGB is added to ColourTable
    public void testInvalidRGBSubceeding() {
        ColourTable colourTable = new ColourTable(4);
        int[] invalidRGBValue = {-1, 0, 0};
        ArrayIndexOutOfBoundsException exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            colourTable.add(invalidRGBValue);
        });

        // Check correct exception message is thrown
        assertEquals("Invalid RGB value: " + invalidRGBValue, exception.getMessage());
    }

    @Test
    // Test whether an exception is thrown when an invalid RGB is added to ColourTable
    public void testInvalidRGBInvalidLength() {
        ColourTable colourTable = new ColourTable(4);
        int[] invalidRGBValue = {0, 0};
        ArrayIndexOutOfBoundsException exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            colourTable.add(invalidRGBValue);
        });

        // Check correct exception message is thrown
        assertEquals("Invalid RGB value: " + invalidRGBValue, exception.getMessage());
    }

    @Test
    // Test whether an exception is thrown when the capacity of the palette is larger than 1025
    public void testInvalidCapacityExceeding() {
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            ColourTable colourTable = new ColourTable(1026);
        });
    }

    @Test
    // Test whether an exception is thrown when the capacity of the palette is smaller than 2
    public void testInvalidCapacitySubceeding() {
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            ColourTable colourTable = new ColourTable(1);
        });
    }

    @Test
    // Test whether an exception is thrown when the capacity of the palette is not a power of 2
    public void testInvalidCapacityNotPowerOf2() {
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            ColourTable colourTable = new ColourTable(7);
        });
    }

    @Test
    // Test whether an exception is thrown when the capacity of the palette is exceeded
    public void testExceedingCapacity() {
        ColourTable colourTable = new ColourTable(4);
        int[] value1 = {0, 0, 100};
        int[] value2 = {10, 0, 100};
        int[] value3 = {0, 20, 100};
        int[] value4 = {50, 0, 100};
        int[] value5 = {0, 50, 100};

        colourTable.add(value1);
        colourTable.add(value2);
        colourTable.add(value3);
        colourTable.add(value4);

        assertEquals(4, colourTable.getSize());

        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            colourTable.add(value5);
        });

        assertEquals(4, colourTable.getSize());
    }

    @Test
    // Test that multiple RGB values are added to the palette correctly
    public void testSize() {
        ColourTable colourTable = new ColourTable(8);

        int[] value1 = {20, 60, 20};
        colourTable.add(value1);

        assertEquals(1, colourTable.getSize());
        assertTrue(colourTable.contains(value1));

        int[] value2 = {80, 200, 150};
        colourTable.add(value2);

        assertEquals(2, colourTable.getSize());
        assertTrue(colourTable.contains(value2));

        int[] value3 = {200, 100, 200};
        colourTable.add(value3);

        assertEquals(3, colourTable.getSize());
        assertTrue(colourTable.contains(value3));
    }

    @Test
    // Test whether the capacity returned by getCapacity is correct
    public void testValidCapacity() {
        ColourTable colourTable = new ColourTable(4);
        assertEquals(4, colourTable.getCapacity());
    }

    @Test
    // Test whether an exception is thrown when a duplicate colour is added to the palette
    public void testDuplicateColours() {
        ColourTable colourTable = new ColourTable(4);
        int[] value1 = {1, 1, 1};
        colourTable.add(value1);
        assertEquals(1, colourTable.getSize());
        int[] value2 = {1, 1, 1};

        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            colourTable.add(value2);
        });

        assertEquals(1, colourTable.getSize());
    }

    @Test
    // Test whether an RGB value can be looked up in the palette
    public void testLookUpRGBInPalette() {
        ColourTable colourTable = new ColourTable(4);

        int[] rgbColourToAdd = {255, 0, 0};
        colourTable.add(rgbColourToAdd);

        // Specify the index to test
        int indexToTest = 0;

        // Retrieve the RGB value at the specified index
        int[] retrievedRGB = colourTable.getRGBAtIndex(indexToTest);

        // Assert that the retrieved RGB value matches the expected value
        assertArrayEquals(rgbColourToAdd, retrievedRGB);
    }

    @Test
    // Test whether an exception is thrown when looking up an index that is too large
    public void testLookUpIndexTooLarge() {
        ColourTable colourTable = new ColourTable(4);
        int[] rgbColourToAdd = {255, 0, 0};
        colourTable.add(rgbColourToAdd);
        int indexToTest = 1;
        assertThrows(IndexOutOfBoundsException.class, () -> {
            int[] retrievedRGB = colourTable.getRGBAtIndex(indexToTest);
        });
    }

    @Test
    // Test whether an exception is thrown when looking up an index that is too small
    public void testLookUpIndexTooSmall() {
        ColourTable colourTable = new ColourTable(4);
        int[] rgbColourToAdd = {255, 0, 0};
        colourTable.add(rgbColourToAdd);
        int indexToTest = -1;
        assertThrows(IndexOutOfBoundsException.class, () -> {
            int[] retrievedRGB = colourTable.getRGBAtIndex(indexToTest);
        });
    }
}
