package cn.lcg.java8.chapter8.command;

import java.util.ArrayList;
import java.util.List;
/**
 * @Description 宏 用来记录、执行计划，是个executor
 * @author leon
 * @date 2016年4月22日 下午4:41:02
 */
// BEGIN Macro
public class Macro {

    private final List<Actions> actions;

    public Macro() {
        actions = new ArrayList<>();
    }

    public void record(Actions action) {
        actions.add(action);
    }

    public void run() {
        actions.forEach(Actions::perform);
    }

}
// END Macro