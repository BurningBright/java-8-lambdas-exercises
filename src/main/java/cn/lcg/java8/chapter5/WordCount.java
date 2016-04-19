package cn.lcg.java8.chapter5;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * @Description 统计字符流的出现次数
 *      groupingBy一参为自身，可以用函数反弹
 * @author leon
 * @date 2016年4月19日 下午4:26:58
 */
public class WordCount {
    
    public static Map<String, Long>getWordCount(Stream<String> src) {
        return src.collect(Collectors.groupingBy(n -> n, Collectors.counting()));
    }
    
}
