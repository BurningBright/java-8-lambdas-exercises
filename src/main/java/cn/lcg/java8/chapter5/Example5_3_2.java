package cn.lcg.java8.chapter5;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import cn.lcg.java8.chapter1.Keeper;
import cn.lcg.java8.chapter1.Zoo;
/**
 * @Description 找出饲养队伍最大的组
 *      找出一组动物园的平均动物数
 * @author leon
 * @date 2016年4月18日 下午2:31:36
 */
public class Example5_3_2 {
    
    public static Optional<Keeper> biggestGroup(Stream<Keeper> keepers) {
        Function<Keeper, Long> biggest = keeper -> keeper.getMembers().count();
        return keepers.collect(Collectors.maxBy(Comparator.comparing(biggest)));
    }
    
    public static double averageAnimal(Stream<Zoo> zoos) {
        return zoos.collect(Collectors.averagingDouble(zoo -> zoo.getAnimals().count()));
    }
    
}
