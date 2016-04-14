package cn.lcg.java8.chapter2;

import java.util.function.Predicate;

import org.junit.Test;

/**
 * 
* @Description: 添加模拟接口覆盖check方法时会造成编译紊乱
* @author leon
* @date 2016年3月4日 上午11:13:06
*
 */
public class Excercise3_c {
    
    @Test
    public void checkReload() {
//        InPred ip = x -> x > 0;
//        assert(ip.test(100));
        assert(check(x -> x > 0));
        assert(check_Reload(x -> x > 0));
    }
    
    boolean check(Predicate<Integer> predicate) {
        return predicate.test(6);
    }
    
    boolean check_Reload(InPred predicate) {
        return predicate.test(6);
    }
}
