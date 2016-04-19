package cn.lcg.java8.chapter5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
/**
 * @Description 类泛型，T是输入类型、K是目标类型
 *      接口泛型，T用来Reduce的原始类型，二参累加器/结束器的一参，三参是结果类型
 *      
 * @author leon
 * @date 2016年4月19日 下午4:35:38
 * @param <T>
 * @param <K>
 */
public class GroupingAt<T, K> implements Collector<T, Map<K, List<T>>, Map<K, List<T>>>{
    
    private static final Set<Characteristics> characteristics = Collections.emptySet();
    
    static {
        characteristics.add(Characteristics.IDENTITY_FINISH);
    }
    
    // 函数的输入必须是实际对象的父系引用，输出必须是实际输出引用的子系对象
    private final Function<? super T, ? extends K> classifier;
    
    public GroupingAt(Function<? super T, ? extends K> classifier) {
        this.classifier = classifier;
    }
    
    @Override
    public Supplier<Map<K, List<T>>> supplier() {
        // 自动满足泛型要求
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<K, List<T>>, T> accumulator() {
        /*
         * 累加器返回的是函数，一参是输入参数，二参是返回
         */
        return (map, element) -> {
            // 构造传入函数，用于得到目标key
            K key = classifier.apply(element);
            // 找到累加目标或新建
            List<T> elements = map.computeIfAbsent(key, k -> new ArrayList<>());
            elements.add(element);
        };
    }

    @Override
    public BinaryOperator<Map<K, List<T>>> combiner() {
        // 两边都是Map<K, List<T>>类型
        return (left, right) -> {
            // 以左散列为主，每个右Entry都到散列上试图合并
            right.forEach((key, value) -> {
                /*
                 * 试图合并左散列表的对应key上的Value
                 * 如果左散列上没有或为空，直接插入
                 * BiFunction为合并函数，左右分别为原value和当前value
                 */
                left.merge(key, value, (leftValue, rightValue) -> {
                    leftValue.addAll(rightValue);
                    return leftValue;
                });
            });
            return left;
        };
    }

    @Override
    public Function<Map<K, List<T>>, Map<K, List<T>>> finisher() {
        // 反弹自身，展现IDENTITY_FINISH的特性
        return map -> map;
    }

    @Override
    public Set<java.util.stream.Collector.Characteristics> characteristics() {
        return characteristics;
    }

}
