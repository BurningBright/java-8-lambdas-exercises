package cn.lcg.java8.chapter8.command;
/**
 * @Description 抽象的接收者，提供出一组调用“面板”
 *      像命令者一样是一个管理层，有点API的感觉
 * @author leon
 * @date 2016年4月22日 下午4:36:03
 */
public interface Mobile {
    
    public void call();
    
    public void sms();
    
}
