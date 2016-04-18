package cn.lcg.java8.chapter5;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import cn.lcg.java8.chapter1.Keeper;
import cn.lcg.java8.chapter1.Zoo;

/**
 * @Description 统计每个管理员就职的动物园数
 *      统计主管的任职动物园
 * @author leon
 * @date 2016年4月18日 下午4:05:17
 */
public class Example5_3_6 {
    
    public static Map<Keeper, Long> getKeeperZoos(Stream<Zoo> zoos) {
        /*
         * 1.转变为1个keeper对应1个zoo
         * 2.收集每个keeper对应zoo个数
         */
        class Tmp {
            Keeper keeper;
            @SuppressWarnings("unused")
            Zoo Zoo;
            public Tmp(Keeper keeper, Zoo zoo) {
                this.keeper = keeper;
                this.Zoo = zoo;
            }
            public Keeper getKeeper() {
                return keeper;
            }
        }
        
        return zoos.flatMap(zoo -> {
            return zoo.getZooKeepers().flatMap(keeper -> {
                return Stream.of(new Tmp(keeper, zoo));
            });
        }).collect(Collectors.groupingBy(Tmp::getKeeper, Collectors.counting()));
        
    }
    
    public static Map<Keeper, List<String>> getMainKeeperZoos(Stream<Zoo> zoos) {
        return zoos.collect(Collectors.groupingBy(Zoo::getMainZooKeeper,
                Collectors.mapping(zoo -> zoo.getName(), Collectors.toList())));
    }
    
}
