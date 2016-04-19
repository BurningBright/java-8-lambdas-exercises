package cn.lcg.java8.chapter5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.lcg.java8.chapter1.Keeper;
import cn.lcg.java8.chapter1.Zoo;
/**
 * @Description Lambda表达式带来的其他一些东西
 * @author leon
 * @date 2016年4月19日 上午11:01:13
 */
public class SomeThingElse {
    
    abstract class KeeperService {
        protected Map<String, Keeper> keeperCache = new HashMap<>();
        
        public abstract Keeper getKeeper(String name);
        
        protected Keeper readKeeperFromDB(String name) {
            return new Keeper(name, new ArrayList<Keeper>(), Arrays.asList("feed", "clean"));
        }
    }
    
    class OldKeeperService extends KeeperService {
        // BEGIN KEEPER_CACHE_OLD
        public Keeper getKeeper(String name) {
            Keeper keeper = keeperCache.get(name);
            if (keeper == null) {
                keeper = readKeeperFromDB(name);
                keeperCache.put(name, keeper);
            }
            return keeper;
        }
        // END KEEPER_CACHE_OLD
    }

    class Java8KeeperService extends KeeperService {
        // BEGIN KEEPER_CACHE_COMPUTE
        public Keeper getKeeper(String name) {
            return keeperCache.computeIfAbsent(name, this::readKeeperFromDB);
        }
        // END KEEPER_CACHE_COMPUTE
    }

    class ImperativeCount {

        public Map<Keeper, Integer> countZoos(Map<Keeper, List<Zoo>> zoosByKeeper) {
            // BEGIN COUNT_ZOOS_VALUES_UGLY
            Map<Keeper, Integer> countOfZoos = new HashMap<>();
            for (Map.Entry<Keeper, List<Zoo>> entry : zoosByKeeper.entrySet()) {
                Keeper keeper = entry.getKey();
                List<Zoo> zoos = entry.getValue();
                countOfZoos.put(keeper, zoos.size());
            }
            // END COUNT_ZOOS_VALUES_UGLY
            return countOfZoos;
        }
    }

    class Java8Count {
        public Map<Keeper, Integer> countZoos(Map<Keeper, List<Zoo>> zoosByKeeper) {
            // BEGIN COUNT_ZOOS_VALUES_FOREACH
            Map<Keeper, Integer> countOfZoos = new HashMap<>();
            zoosByKeeper.forEach((keeper, zoos) -> {
                countOfZoos.put(keeper, zoos.size());
            });
            // END COUNT_ZOOS_VALUES_FOREACH
            return countOfZoos;
        }
    }
    
}
