package cn.lcg.java8.chapter3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import cn.lcg.java8.chapter1.SimpleData;
import cn.lcg.java8.chapter1.Zoo;

import static java.util.stream.Stream.concat;
import static org.junit.Assert.*;
import static java.util.stream.Collectors.toList;

/**
 * @Description 常用Stream操作
 * @author leon
 * @date 2016年4月13日 下午6:05:00
 */
public class GeneralOperations {
    
    @Test
    public void testSum() {
        List<Integer> src = Arrays.asList(3,6,8,2,5,8);
        assertEquals(32, addUp(src.stream()));
    }
    
    private int addUp(Stream<Integer> in) {
        return in.reduce(0, (acc, element) -> acc + element);
    }
    
    @Test
    public void testKeeper() {
        /*
         * 拆开饲养员流，组合所有饲养员流
         * 映射所有饲养员流为他们的姓名+工作
         * 字符串流合并到一个字符串中
         */
        String names = SimpleData.getThreeKeepers()
                .flatMap(keeper -> concat(Stream.of(keeper), keeper.getMembers()))
                .map(allKeeper -> {
                    return (allKeeper.getMembers().count()>0? "": "\t") + 
                            allKeeper.getName() + " -> " + 
                             allKeeper.getJobs().reduce("", (acc, ele) -> acc + ele + ",");
                })
                .filter(str -> str.length()>0)
                .map(row -> 
                    row.substring(0, row.length()-1) +";\n"
                )
                .reduce("", (acc, ele) -> acc + ele);
        System.out.println(names);
    }
    
    @Test
    public void testZoo() {
        /*
         * 组合动物园输入
         * 滤过所有动物数大于2的
         * 输出
         */
        List<Zoo> hz_zoo = Stream.of(SimpleData.hzZoo)
                .filter(hz -> hz.getAnimals().count()>2)
                .collect(toList());
        assertEquals(Arrays.asList(SimpleData.hzZoo), hz_zoo);
    }
}
