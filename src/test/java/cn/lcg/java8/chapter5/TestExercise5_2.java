package cn.lcg.java8.chapter5;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.stream.Stream;

import org.junit.Test;

import cn.lcg.java8.chapter1.Keeper;
import cn.lcg.java8.chapter1.SimpleData;

public class TestExercise5_2 {
    
    @Test
    public void testName() {
        Keeper ret1 = LongestKeeperName.inCollector(SimpleData.shZoo.getAllKeepers());
        Keeper ret2 = LongestKeeperName.inReduce(SimpleData.shZoo.getAllKeepers());
        assertEquals(ret1, ret2);
    }
    
    @Test
    public void testWord() {
        Map<String, Long> result = WordCount.getWordCount(Stream.of("a", "b", "a"));
        result.entrySet().forEach(a -> System.out.println(a.getKey() + "\t" + a.getValue()));
    }
    
}
