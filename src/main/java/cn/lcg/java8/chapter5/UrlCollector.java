package cn.lcg.java8.chapter5;

import java.util.Map.Entry;
import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
/**
 * @Description url地址收集器
 *      实现收集器接口，泛型写键值对、合并器、结果
 * @author leon
 * @date 2016年4月19日 上午11:02:02
 */
public class UrlCollector implements Collector<Entry<String, String>, UrlCombiner, String>{
    
    private static final Set<Characteristics> characteristics = Collections.emptySet();
    
    private final String domain;
    private final String address;
    
    public UrlCollector(String domain, String address) {
        this.domain = domain;
        this.address = address;
    }
    
    @Override
    public Supplier<UrlCombiner> supplier() {
        return () -> new UrlCombiner(domain, address);
    }

    @Override
    public BiConsumer<UrlCombiner, Entry<String, String>> accumulator() {
        return UrlCombiner::add;
    }

    @Override
    public BinaryOperator<UrlCombiner> combiner() {
        return UrlCombiner::merge;
    }

    @Override
    public Function<UrlCombiner, String> finisher() {
        return UrlCombiner::toString;
    }

    @Override
    public Set<java.util.stream.Collector.Characteristics> characteristics() {
        return characteristics;
    }

}
