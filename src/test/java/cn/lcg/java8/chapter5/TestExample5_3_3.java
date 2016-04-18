package cn.lcg.java8.chapter5;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.lcg.java8.chapter1.Keeper;
import cn.lcg.java8.chapter1.SimpleData;
import cn.lcg.java8.chapter1.Zoo;
/**
 * @Description 测试分块单独饲养员/组饲养员
 *      测试用主饲养分组动物园
 *      测试用字符串得出动物园的饲养员名称
 * @author leon
 * @date 2016年4月18日 下午3:11:47
 */
public class TestExample5_3_3 {
    
    @Test
    public void testPartition() {
        Map<Boolean, List<Keeper>> result = Example5_3_3.usePartition(SimpleData.getTwoKeepers());
        assertEquals(SimpleData.zhouXun, result.get(true).get(0));
        assertEquals(SimpleData.pythonGroup, result.get(false).get(0));
    }
    
    @Test
    public void testGroupBy() {
        Map<Keeper, List<Zoo>> result = Example5_3_3.useGroupBy(SimpleData.getTwoZoos());
        assertEquals(SimpleData.hzZoo, result.get(SimpleData.pythonGroup).get(0));
        assertEquals(SimpleData.shZoo, result.get(SimpleData.horseGroup).get(0));
    }
    
    @Test
    public void testJoining() {
        String result = Example5_3_3.useJoining(SimpleData.hzZoo);
        System.out.println(result);
    }
    
}
