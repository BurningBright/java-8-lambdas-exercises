package cn.lcg.java8.chapter5;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import cn.lcg.java8.chapter1.Keeper;
/**
 * @Description 比较收集器和reduce之间的差别
 *      使用公用比较器比较名字长度
 *      相较来说收集器比较直观
 *      reduce还不错，但暴露了逻辑
 * @author leon
 * @date 2016年4月19日 下午4:12:59
 */
public class LongestKeeperName {
    
    public static Comparator<Keeper> byNameLength = Comparator.comparing(keeper -> keeper.getName().length());
    
    public static Keeper inCollector(Stream<Keeper> src) {
         return src.collect(Collectors.maxBy(byNameLength))
                 .orElseThrow(RuntimeException::new);
    }
    
    public static Keeper inReduce(Stream<Keeper> src) {
        return src.reduce((acc, keeper) -> {
            return (byNameLength.compare(acc, keeper) > 0) ? acc: keeper;
        }).orElseThrow(RuntimeException::new);
    }
    
}
