package cn.lcg.java8.chapter3;

import java.util.List;
import java.util.Set;

import cn.lcg.java8.chapter1.Zoo;
import static java.util.stream.Collectors.toSet;

/**
 * @Description 选定一组动物园，找出其中所有年龄大于2岁的动物
 * @author leon
 * @date 2016年4月17日 下午8:48:38
 */
public class Example3_4 {

    public static Set<String> findAgeAnimals(List<Zoo> zoos) {
        return zoos.stream().flatMap(zoo -> zoo.getAnimals())
                .filter(animal -> animal.getAge() > 2)
                .map(animal -> animal.getName())
                .collect(toSet());
    }
}
