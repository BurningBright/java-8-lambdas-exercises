package cn.lcg.java8.chapter5;

import java.util.HashMap;
import java.util.Map;
/**
 * @Description lambda表达式的嵌套表达，帅
 * @author leon
 * @date 2016年4月19日 下午6:07:41
 */
public class Fibonacci {

    private final Map<Integer,Long> cache;

    public Fibonacci() {
        cache = new HashMap<>();
        cache.put(0, 0L);
        cache.put(1, 1L);
    }

    public long fibonacci(int x) {
        /*
         * 如果为0/1 由于缓存里已有，不会迭代
         * 如果x>1 缓存中没有，会迭代至1
         */
        return cache.computeIfAbsent(x, n -> fibonacci(n-1) + fibonacci(n-2));
    }

}
