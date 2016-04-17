package cn.lcg.java8.chapter3;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @Description 测试字符串流的效果
 * @author leon
 * @date 2016年4月17日 下午9:31:57
 */
public class TestExercise6_7 {
    
    @Test
    public void testLowCase() {
        String str = "Leon Lin";
        assertEquals(5, Exercise6_7.countLowerCaseLetter(str));
    }
    
    @Test
    public void testGetMax() {
//        String[] str = {"are", "", "Synchronized", "throw you roll"};
//        assertEquals("throw you roll", Exercise6_7.findMaxLengthString(str).get());
        String[] str={};
        assertEquals(false, Exercise6_7.findMaxLengthString(str).isPresent());
    }
}
