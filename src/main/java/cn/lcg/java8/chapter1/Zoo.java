package cn.lcg.java8.chapter1;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;

/**
 * @Description 动物园
 * @author leon
 * @date 2016年4月13日 下午1:31:25
 */
public class Zoo implements Performance{
    
    private String name;
    private List<Animal> animals;
    private List<Keeper> zooKeepers;
    
    public Zoo(String name, List<Animal> animals, List<Keeper> zooKeepers) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(animals);
        Objects.requireNonNull(zooKeepers);
        
        this.name = name;
        this.animals = new ArrayList<>(animals);
        this.zooKeepers = new ArrayList<>(zooKeepers);
    }
    
    public String getName() {
        return name;
    }
    
    public Stream<Animal> getAnimals() {
        return animals.stream();
    }
    
    public List<Animal> getAnimalList() {
        return unmodifiableList(animals);
    }
    
    public Stream<Keeper> getZooKeepers() {
        return zooKeepers.stream();
    }
    
    public List<Keeper> getZooKeeperList() {
        return unmodifiableList(zooKeepers);
    }
    
    public Keeper getMainZooKeeper() {
        return zooKeepers.get(0);
    }
    
    public Zoo copy() {
        List<Animal> animals = getAnimals().map(Animal::copy).collect(toList());
        List<Keeper> zooKeepers = getZooKeepers().map(Keeper::copy).collect(toList());
        return new Zoo(name, animals, zooKeepers);
    }

}
