package cn.lcg.java8.chapter3;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Set;

import org.junit.Test;

import cn.lcg.java8.chapter1.SimpleData;
/**
 * @Description 测试代码重构的效果
 * @author leon
 * @date 2016年4月17日 下午9:31:33
 */
public class TestExample3_4 {
    
    @Test
    public void testRestructure() {
        Set<String> result = Example3_4.findAgeAnimals(SimpleData.getTwoZooList());
        assertTrue(result.containsAll(Arrays.asList(SimpleData.tiger.getName(), SimpleData.horse.getName())));
    }
    
}
