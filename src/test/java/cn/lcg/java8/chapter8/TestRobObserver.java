package cn.lcg.java8.chapter8;

import org.junit.Test;

import cn.lcg.java8.chapter8.observer.Bank;
import cn.lcg.java8.chapter8.observer.Gangster;
import cn.lcg.java8.chapter8.observer.Police;

/**
 * @Description 测试抢劫观察者
 * @author leon
 * @date 2016年4月25日 上午10:32:26
 */
public class TestRobObserver {
    
    @Test
    public void testRob() {
        Bank b = new Bank(null);
        b.startRobbing(new Police(null));
        b.startRobbing(new Gangster());
//        b.startRobbing(Police::new);
        b.robbing("We Got it , let's go");
    }
    
}
