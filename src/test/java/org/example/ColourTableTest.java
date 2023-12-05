package org.example;

import org.example.ColourTable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ColourTableTest {
    @Test
    //test that the constructor created a palette of the size of the parameter
    public void testConstructorMethod() {
        ColourTable colourTable=new ColourTable(4);
        assertEquals(4,colourTable.getCapacity());
    }

    @Test
    public void testAddMethod(){
        //test method to make sure add method works correctly:
        //the size increases, the colour table contains it and that the index is returned
        ColourTable colourTable = new ColourTable(4);
        int initialSize=colourTable.getSize();
        int [] rgbColourToAdd={255,0,0};
        int index = colourTable.add(rgbColourToAdd);

        assertEquals(initialSize +1, colourTable.getSize());
        assertTrue(colourTable.contains(rgbColourToAdd));
        assertEquals(0,index);
    }

    @Test
    public void testInvalidRGBExceeding(){
        //test whether an exception is thrown when an invalid RBG is attempted to be added to colourTable
        ColourTable colourTable=new ColourTable(4);
        int[] invalidRGBValue={0,0,256};
        ArrayIndexOutOfBoundsException exception=assertThrows(ArrayIndexOutOfBoundsException.class,()->{colourTable.add(invalidRGBValue);});
        //check correct exception message is thrown
        assertEquals("Invalid RGB value: " + invalidRGBValue, exception.getMessage());
    }

    @Test
    public void testInvalidRGBSubceeding(){
        //test whether an exception is thrown when an invalid RBG is attempted to be added to colourTable
        ColourTable colourTable=new ColourTable(4);
        int[] invalidRGBValue={-1,0,0};
        ArrayIndexOutOfBoundsException exception=assertThrows(ArrayIndexOutOfBoundsException.class,()->{colourTable.add(invalidRGBValue);});
        //check correct exception message is thrown
        assertEquals("Invalid RGB value: " + invalidRGBValue, exception.getMessage());
    }


}
