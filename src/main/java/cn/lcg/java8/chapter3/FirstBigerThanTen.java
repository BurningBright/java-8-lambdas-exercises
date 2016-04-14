package cn.lcg.java8.chapter3;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 
* @Description: 找到第一个大于10的数字
* @author leon
* @date 2016年3月4日 上午11:11:46
*
 */
public class FirstBigerThanTen {
    
    @Test
    public void calc() {
        List<Integer> src = new ArrayList<>();
        for(int i=0; i<10; i++) {
            int t = (int)(Math.random()*20);
            System.out.println(i + " -> " + t);
            src.add(t);
        }
        
        System.out.println(src.stream().filter(x -> x > 10).findFirst().get());
    }
    
}
