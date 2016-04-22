package cn.lcg.java8.chapter8.command;
/**
 * @Description 抽象的命令者，管理层往往承上启下
 *          实际做的事不是很多，但往往比较重要[Runable]
 * @author leon
 * @date 2016年4月22日 下午4:32:59
 */
public interface Actions {
    
    public void perform();
    
}
