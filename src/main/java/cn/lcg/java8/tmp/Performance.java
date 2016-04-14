package cn.lcg.java8.tmp;

import java.util.stream.Stream;

import static java.util.stream.Stream.concat;

/**
 * 
* @Description: 用于展示
* @author leon
* @date 2016年3月4日 上午11:16:46
*
 */
public interface Performance {
    
    public String getName();
    
    public Stream<Engineer> getDevelopers();
    
    // Test
    public default Stream<Engineer> getAllDevelopers() {
        return getDevelopers().flatMap(engineer -> {
            return concat(Stream.of(engineer), engineer.getMembers());
        });
    }
    
}
