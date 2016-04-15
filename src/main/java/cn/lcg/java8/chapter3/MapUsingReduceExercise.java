package cn.lcg.java8.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;
/**
 * @Description 用映射函数，代替了map的映射
 *      用reduce循环累加出结果，第三参数是个问题
 * @author leon
 * @date 2016年4月15日 上午10:41:00
 */
public class MapUsingReduceExercise {
    
    public static <I, O> List<O> map(Stream<I> stream, Function<I, O> map) {
        return stream.reduce(new ArrayList<O>(), (acc, element) -> {
            acc.add(map.apply(element));
            return acc;
        }, (a, b) -> a);
    }
}
