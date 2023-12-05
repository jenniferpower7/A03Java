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

    @Test
    public void testInvalidRGBInvalidLength(){
        //test whether an exception is thrown when an invalid RBG is attempted to be added to colourTable
        ColourTable colourTable=new ColourTable(4);
        int[] invalidRGBValue={0,0};
        ArrayIndexOutOfBoundsException exception=assertThrows(ArrayIndexOutOfBoundsException.class,()->{colourTable.add(invalidRGBValue);});
        //check correct exception message is thrown
        assertEquals("Invalid RGB value: " + invalidRGBValue, exception.getMessage());


    }
    @Test
    public void testInvalidCapacityExceeding(){
        //test whether an exception is thrown when the  capacity of the palette is invalid as it is larger than 1025
        IllegalStateException exception = assertThrows(IllegalStateException.class,()->{ColourTable colourTable=new ColourTable(1026);});

    }
    @Test
    public void testInvalidCapacitySubceeding(){
        //test whether an exception is thrown when the  capacity of the palette is invalid as it is smaller than 2
        IllegalStateException exception = assertThrows(IllegalStateException.class,()->{ColourTable colourTable=new ColourTable(1);});

    }

    @Test
    public void testInvalidCapacityNotPowerOf2(){
        //test whether an exception is thrown when the  capacity of the palette is invalid as it is not a power of 2
        IllegalStateException exception = assertThrows(IllegalStateException.class,()->{ColourTable colourTable=new ColourTable(7);});

    }

    @Test
    public void testExceedingCapacity(){
        //test whether an exception is thrown when the capacity of the palette is exceeded
        ColourTable colourTable=new ColourTable(4);
        int[] value1={0,0,100};
        int[] value2={10,0,100};
        int[] value3={0,20,100};
        int[] value4={50,0,100};
        int[] value5={0,50,100};

        colourTable.add(value1);
        colourTable.add(value2);
        colourTable.add(value3);
        colourTable.add(value4);

        assertEquals(4, colourTable.getSize());

        IndexOutOfBoundsException exception= assertThrows(IndexOutOfBoundsException.class,()->{colourTable.add(value5);});

        assertEquals(4, colourTable.getSize());

    }


}
