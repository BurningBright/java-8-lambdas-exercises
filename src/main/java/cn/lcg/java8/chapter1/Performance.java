package cn.lcg.java8.chapter1;

import static java.util.stream.Stream.concat;

import java.util.stream.Stream;

/**
 * @Description 动物园的展示接口
 * @author leon
 * @date 2016年4月13日 下午4:08:36
 */
public interface Performance {
    
    public String getName();
    
    public Stream<Keeper> getZooKeepers();
    
    public default Stream<Keeper> getAllKeepers() {
        return getZooKeepers().flatMap(keeper -> {
            return concat(Stream.of(keeper), keeper.getMembers());
        });
    }
}
