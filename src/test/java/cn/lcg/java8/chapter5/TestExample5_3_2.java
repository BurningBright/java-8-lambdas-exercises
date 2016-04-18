package cn.lcg.java8.chapter5;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;

import cn.lcg.java8.chapter1.Keeper;
import cn.lcg.java8.chapter1.SimpleData;

/**
 * @Description 测试收集器将流转为值
 * @author leon
 * @date 2016年4月18日 下午2:52:50
 */
public class TestExample5_3_2 {
    
    @Test
    public void testFindBiggest() {
        Optional<Keeper> keeper = Example5_3_2.biggestGroup(SimpleData.getThreeKeepers());
        assertEquals(SimpleData.tigerGroup, keeper.get());
    }
    
    @Test
    public void testAverageAnimal() {
        double i = Example5_3_2.averageAnimal(SimpleData.getTwoZoos());
        // 三参为delta，误差之内依旧相等
        assertEquals(3, i, 0);
    }
}
