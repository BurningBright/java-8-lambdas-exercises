package cn.lcg.java8.chapter8.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 银行可被抢劫
 * @author leon
 * @date 2016年4月25日 上午10:20:13
 */
public class Bank {
    
    private List<RobObserver> observers = new ArrayList<>();
    
    public Bank(RobObserver observer) {
        observers.add(observer);
    }

    public void robbing(String event) {
        for (RobObserver observer : observers) {
            observer.observerRobbing(event);
        }
    }
    
    public void startRobbing(RobObserver observer) {
        observers.add(observer);
    }
    
}
