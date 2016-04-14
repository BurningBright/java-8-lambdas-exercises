package cn.lcg.java8.tmp;

/**
 * 
* @Description: 描述系统属性
* @author leon
* @date 2016年3月4日 上午11:18:25
*
 */
public class System_ {
    
    private String name;
    private int size;
    
    public System_(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
    
    public System_ copy() {
        return new System_(name, size);
    }
}
