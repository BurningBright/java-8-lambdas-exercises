package cn.lcg.java8.chapter1;

import java.util.Date;

/**
 * @Description 动物
 * @author leon
 * @date 2016年4月13日 下午1:40:31
 */
public class Animal {
    
    private String name;
    private Date birthday;
    private double age;
    
    public Animal(String name, Date birthday, double age) {
        this.name = name;
        this.birthday = birthday;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public Date getBirthday() {
        return birthday;
    }
    
    public double getAge() {
        return age;
    }
    
    public Animal copy() {
        return new Animal(name, birthday, age);
    }
}
