package cn.lcg.java8.chapter5;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.Test;

import cn.lcg.java8.chapter1.SimpleData;
/**
 * @Description 测试方法引用
 * @author leon
 * @date 2016年4月19日 下午3:50:17
 */
public class TestExcercise5_1 {
    
    @Test
    public void upperCase() {
        String result = Exercise5_1.toUpperString(Stream.of("you", " poor", " coward"));
        assertEquals("YOU POOR COWARD", result);
    }
    
    @Test
    public void reduceCount() {
        int result = Exercise5_1.reduceCounting(SimpleData.getThreeAnimals());
        assertEquals(3, result);
    }
    
    @Test
    public void linkList() {
        long result = Exercise5_1.linkingList(Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 5)));
        assertEquals(15, result);
    }
    
}
