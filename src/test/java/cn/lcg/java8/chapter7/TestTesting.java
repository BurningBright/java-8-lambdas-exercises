package cn.lcg.java8.chapter7;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.lcg.java8.chapter1.SimpleData;

/**
 * @Description 测试lambda在构建上的简洁
 * @author leon
 * @date 2016年4月22日 下午2:11:11
 */
public class TestTesting {
    
    @Test
    public void test() {
        Testing t = new Testing(SimpleData.getTwoZooList());
        
        assertEquals(12, t.countAges());
        assertEquals(22, t.countKeepers());
        assertEquals(6, t.countAnimals());
    }
    
}
