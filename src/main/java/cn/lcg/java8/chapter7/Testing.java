package cn.lcg.java8.chapter7;

import java.util.List;
import java.util.function.ToLongFunction;

import cn.lcg.java8.chapter1.Zoo;
/**
 * @Description 对同一模式，抽取共同特征
 *      传入差异部分函数实现代码简化
 * @author leon
 * @date 2016年4月22日 下午2:08:51
 */
public class Testing {
    
    private List<Zoo> zoos;
    
    public Testing(List<Zoo> zoos) {
        this.zoos = zoos;
    }
    
    private long countFeature(ToLongFunction<Zoo> function) {
        return zoos.stream().mapToLong(function).sum();
    }
    
    public long countAnimals() {
        return countFeature(zoo -> zoo.getAnimals().count());
    }
    
    public long countAges() {
        return countFeature(zoo -> zoo.getAnimals().mapToLong(animal -> (long)animal.getAge()).sum());
    }
    
    public long countKeepers() {
        return countFeature(zoo -> zoo.getAllKeepers().count());
    }
    
}
