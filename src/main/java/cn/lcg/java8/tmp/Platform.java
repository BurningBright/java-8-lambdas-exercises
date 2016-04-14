package cn.lcg.java8.tmp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.toList;

/**
 * 
* @Description: 软件平台类，描述平台构成、属性、开发者
* @author leon
* @date 2016年3月4日 上午11:17:03
*
 */
public class Platform {
    
    private String name;
    private List<System_> systems;
    private List<Engineer> developers;
    
    public Platform(String name, List<System_> systems, List<Engineer> developers) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(systems);
        Objects.requireNonNull(developers);
        
        this.name = name;
        this.systems = new ArrayList<System_>(systems);
        this.developers = new ArrayList<Engineer>(developers);
        
    }

    public String getName() {
        return name;
    }

    public Stream<System_> getSystems() {
        return systems.stream();
    }

    public List<System_> getSystemList() {
        return unmodifiableList(systems);
    }

    public Stream<Engineer> getDevelopers() {
        return developers.stream();
    }

    public List<Engineer> getDeveloperList() {
        return unmodifiableList(developers);
    }

    public Engineer getMainDeveloper() {
        return developers.get(0);
    }
    
    public Platform copy() {
        List<System_> sys = getSystems().map(System_::copy).collect(toList());
        List<Engineer> deve = getDevelopers().map(Engineer::copy).collect(toList());
        return new Platform(name, sys, deve);
    }
}
