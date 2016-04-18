package cn.lcg.java8.chapter4;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import cn.lcg.java8.chapter1.Keeper;
/**
 * @Description 重构动物管理员们的取值方法，使用Optional代替捕获异常
 *      在取名字时继续惰性求值，做null值判断。
 * @author leon
 * @date 2016年4月18日 上午9:27:36
 */
public class Keepers {
    
    private List<Keeper> keepers;
    
    public Keepers(List<Keeper> keepers) {
        this.keepers = new ArrayList<Keeper>(keepers);
    }
    
    public Optional<Keeper> getKeeper(int index) {
        if(index < 0 || index > keepers.size()-1) {
            return Optional.empty();
        }
        return Optional.of(keepers.get(index));
    }
    
    public String getKeeperName(int index) {
        Optional<Keeper> keeper = getKeeper(index);
//        if(keeper.isPresent()) {
//            return keeper.get().getName();
//        } else {
//            return "unknow";
//        }
        // 保持相同行为，继续高级函数的惰性求值。
        return keeper.map(Keeper::getName).orElse("unknow");
    }
}
