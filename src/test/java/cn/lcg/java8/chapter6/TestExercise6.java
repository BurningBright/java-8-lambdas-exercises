package cn.lcg.java8.chapter6;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.Test;

public class TestExercise6 {
    
    @Test
    public void test6_10() {
        int ret = Exercise6.sequentialSumOfSquares(IntStream.of(1, 2, 3, 4, 5, 6, 7));
        assertEquals(28, ret);
    }
    
    @Test
    public void test6_11() {
        int wrong = Exercise6.multiplyThrough(Arrays.asList(1, 2, 3));
        int right = Exercise6.multiplyThrough(Arrays.asList(1, 2, 3), null);
        assertEquals(750, wrong);
        assertEquals(30, right);
    }
    
    
}
