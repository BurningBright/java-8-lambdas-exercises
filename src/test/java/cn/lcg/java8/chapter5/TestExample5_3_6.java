package cn.lcg.java8.chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.lcg.java8.chapter1.Keeper;
import cn.lcg.java8.chapter1.SimpleData;

/**
 * @Description 测试1对多的反转统计
 *      1动物园对应多饲养员
 *      统计1饲养员在几家动物园任职
 *  测试主管的任职动物园
 * @author leon
 * @date 2016年4月18日 下午5:35:56
 */
public class TestExample5_3_6 {
    
    @Test
    public void testKeeperZoos() {
        Map<Keeper, Long> result = Example5_3_6.getKeeperZoos(SimpleData.getTwoZoos());
        result.forEach((k, v) -> {
            System.out.println(v + "\t" + k.getName());
        });
    }
    
    @Test
    public void testMainKeeperZoos() {
        Map<Keeper, List<String>> result = Example5_3_6.getMainKeeperZoos(SimpleData.getTwoZoos());
        result.forEach((k, v) -> {
            System.out.println(Arrays.toString(v.toArray()) + "\t" + k.getName());
        });
    }
    
}
