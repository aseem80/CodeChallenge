package io.concur.interview;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest

{

    @Test
    public void hasCoupleForSumUniqueElements() {
        Integer[] input = {1,2,3,10,32,11,31,7,9,10};
        assertTrue(App.hasCoupleForSum(input));
    }

    @Test
    public void hasCoupleForSumNonUniqueElements() {
        Integer[] input = {21,2,3,21,7,6};
        assertTrue(App.hasCoupleForSum(input));


    }

    @Test
    public void hasCoupleForSumNonUniqueElementsWithout21Repeating() {
        Integer[] input = {21,2,3,9,7,6};
        assertFalse(App.hasCoupleForSum(input));


    }

    @Test
    public void noElements() {
        Integer[] input = {1,2,3,21,7,6};
        assertFalse(App.hasCoupleForSum(input));
    }

}
