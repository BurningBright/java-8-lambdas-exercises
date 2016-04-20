package cn.lcg.java8.chapter3;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;
/**
 * @Description 测试Reduce的累加器、合并器[好像没什么用]
 * @author leon
 * @date 2016年4月17日 下午9:32:26
 */
public class UsingReduceTest {
    
    @Test
    public void testFilter() {
        List<Integer> result = FilterUsingReduceExercise.filter(Stream.of(1, 2, 3, 4, 5, 6), a -> a>3);
        assertEquals(Arrays.asList(4,5,6), result);
    }
    
    @Test
    public void testMap() {
        List<String> result = MapUsingReduceExercise.map(Stream.of(1, 2, 3, 4, 5, 6), a -> new String(a+"1"));
        result.stream().forEach(a-> System.out.println(a));
    }
    
    @Test
    public void testReduce() {
        int i = Stream.of(1,2,3).reduce(0, (acc, ele) -> acc + ele);
        System.out.println(i);
    }
}
