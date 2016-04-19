package cn.lcg.java8.chapter5;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import cn.lcg.java8.chapter1.Animal;
/**
 * @Description 方法引用的改写，有点c++中命名空间的感觉
 * @author leon
 * @date 2016年4月19日 下午3:49:10
 */
public class Exercise5_1 {
    
    public static String toUpperString(Stream<String> src) {
        return src.map(String::toUpperCase).reduce("", (acc, ele) -> acc + ele);
    }
    
    public static int reduceCounting(Stream<Animal> src) {
        Optional<Integer> result = src.map(animal -> 1).reduce(Integer::sum);
        if(result.isPresent()) {
            return result.get();
        }
        return 0;
    }
    
    public static long linkingList(Stream<List<Integer>> src) {
        Optional<Integer> result = src.flatMap(List::stream).reduce(Integer::sum);
        if(result.isPresent()) {
            return result.get();
        }
        return 0;
    }
    
}
