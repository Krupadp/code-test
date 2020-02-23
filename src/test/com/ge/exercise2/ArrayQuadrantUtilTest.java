package com.ge.exercise2;

import org.junit.Assume;
import org.junit.Test;
import static org.junit.Assert.*;

import static org.junit.Assert.assertArrayEquals;

public class ArrayQuadrantUtilTest {

    @Test
    public void getQuadrantValuesTest() {
        char[][] data = {
                {'a', 'b', 'c', 'd'},
                {'e', 'f', 'g', 'h'},
                {'i', 'j', 'k', 'l'},
                {'m', 'n', 'o', 'p'}
        };

        ArrayQuadrantUtil util = new ArrayQuadrantUtil(data);
        Assume.assumeNotNull(util.getQuadrantValues(0, 0));

        char[] expectedResult = {'a', 'b', 'e', 'f'};
        assertArrayEquals(expectedResult, util.getQuadrantValues(0, 0));
    }
    @Test
    public void getCoulmnValuesTest() {
        char[][] data = {
                {'a', 'b', 'c', 'd'},
                {'e', 'f', 'g', 'h'},
                {'i', 'j', 'k', 'l'},
                {'m', 'n', 'o', 'p'}
        };

        ArrayQuadrantUtil util = new ArrayQuadrantUtil(data);
        Assume.assumeNotNull(util.getColumnValues(0));

        char[] expectedResult = {'a', 'e', 'i', 'm'};
        assertArrayEquals(expectedResult, (char[])util.getColumnValues(0));
    }
    @Test
    public void getRowValuesTest() {
        char[][] data = {
                {'a', 'b', 'c', 'd'},
                {'e', 'f', 'g', 'h'},
                {'i', 'j', 'k', 'l'},
                {'m', 'n', 'o', 'p'}
        };

        ArrayQuadrantUtil util = new ArrayQuadrantUtil(data);
        Assume.assumeNotNull(util.getRowValues(0));

        char[] expectedResult = {'a', 'b', 'c', 'd'};
        assertArrayEquals(expectedResult, util.getRowValues(0));
    }
}