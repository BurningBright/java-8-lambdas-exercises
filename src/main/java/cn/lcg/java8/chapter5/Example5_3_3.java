package cn.lcg.java8.chapter5;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import cn.lcg.java8.chapter1.Keeper;
import cn.lcg.java8.chapter1.Zoo;

/**
 * @Description 分块、分组收集
 *      字符串收集器 间隔、前缀、后缀
 * @author leon
 * @date 2016年4月18日 下午3:13:26
 */
public class Example5_3_3 {
    
    public static Map<Boolean, List<Keeper>> usePartition(Stream<Keeper> keepers) {
//        return keepers.collect(Collectors.partitioningBy(keeper -> keeper.getMembers().count() == 0));
        return keepers.collect(Collectors.partitioningBy(Keeper::isSolo));
    }
    
    public static Map<Keeper, List<Zoo>> useGroupBy(Stream<Zoo> zoos) {
//         分组对象必须和Key的类型相匹配
        return zoos.collect(Collectors.groupingBy(zoo -> zoo.getMainZooKeeper()));
    }
    
    public static String useJoining(Zoo zoo) {
        return zoo.getAllKeepers().map(Keeper::getName).collect(Collectors.joining(",", "[", "]"));
    }
    
}
