package cn.lcg.java8.chapter8.observer;
/**
 * @Description 黑帮观察银行抢劫发生后吸引警察注意，去抢其他银行
 * @author leon
 * @date 2016年4月25日 上午10:23:15
 */
public class Gangster implements RobObserver{

    @Override
    public void observerRobbing(String event) {
        if(event.contains("Got")) {
            System.out.println("gangster: Yes go go go ~~~");
        }
    }

}
