package cn.lcg.java8.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @Description 联系3.10.1 用reduce代替filter [三参reduce 不仅可以累加，还可以把累加值合并?]
 *              第二参BiFunction<List<T>, ? super T, List<T>> accumulator 累加器
 *              是一个二元函数，接受两参，返回结果，是个变形的Function
 *                  它的二参就是迭代的当前元素element,它可以是任意继承了T的对象。
 * @author leon
 * @date 2016年4月15日 上午9:29:45
 */
public class FilterUsingReduceExercise {

    public static <T> List<T> filter(Stream<T> stream, Predicate<T> predicate) {
        List<T> initial = new ArrayList<T>();
        return stream.reduce(initial, (List<T> acc, T element) -> {
            if (predicate.test(element)) {
                List<T> newAcc = new ArrayList<T>(acc);
                newAcc.add(element);
                return newAcc;
            } else {
                return acc;
            }
        }, FilterUsingReduceExercise::listCombiner);
    }

    private static <T> List<T> listCombiner(List<T> left, List<T> right) {
        // List<T> result = new ArrayList<T>();
        // result.addAll(right);
        // System.out.println("xx");
        return null;
    }

}
