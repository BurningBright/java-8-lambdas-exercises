package cn.lcg.java8.chapter8.observer;
/**
 * @Description 警察观察银行被抢后，阻止抢劫
 * @author leon
 * @date 2016年4月25日 上午10:24:44
 */
public class Police implements RobObserver {
    
    public Police(String xx) {
        super();
        System.out.println("---"+xx);
    }
    
    @Override
    public void observerRobbing(String event) {
        System.out.println(event);
        if(event.contains("Got")) {
            System.out.println("police: Shit go go go !!!");
        }
    }

}
