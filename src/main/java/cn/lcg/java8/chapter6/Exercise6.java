package cn.lcg.java8.chapter6;

import java.util.List;
import java.util.stream.IntStream;
/**
 * @Description 数据处理并行练习
 *      数据处理需要注意数据间联系，避免Bug
 *      并行处理性能优化
 * @author leon
 * @date 2016年4月21日 下午4:51:15
 */
public class Exercise6 {
    
    public static int sequentialSumOfSquares(IntStream range) {
        return range.parallel().map(x -> x * x).sum();
    }
    
    public static int multiplyThrough(List<Integer> linkedListOfNumbbers) {
        return linkedListOfNumbbers.parallelStream().reduce(5, (acc, ele) -> acc * ele);
    }
    
    public static int multiplyThrough(List<Integer> linkedListOfNumbbers, Integer i) {
        return 5 * linkedListOfNumbbers.parallelStream().reduce(1, (acc, ele) -> acc * ele);
    }
    
}
