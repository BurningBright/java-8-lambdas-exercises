package cn.lcg.java8.chapter8;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cn.lcg.java8.chapter8.command.Call;
import cn.lcg.java8.chapter8.command.Macro;
import cn.lcg.java8.chapter8.command.Mobile;
import cn.lcg.java8.chapter8.command.Sms;
/**
 * @Description 测试宏命令者模式
 * @author leon
 * @date 2016年4月25日 上午10:33:10
 */
public class TestMacrosCommand {
    
    @Test
    public void baseCommand() {
        Macro macro = new Macro();
        MockMobile mobile = new MockMobile();
        macro.record(new Call(mobile));
        macro.record(new Sms(mobile));
        macro.run();
        
        mobile.check();
    }
    
    @Test
    public void lambdaBaseCommand() {
        Macro macro = new Macro();
        MockMobile mobile = new MockMobile();
        
        /*
         * 自身就是指令，跳过了类方法的对象引用调用，去掉了类的外壳
         * 可这个接口引用的限制是怎么跳过的？自动适配？
         * 
         *  自动根据上下文判断方法需要一个Actions的引用，
         *  将实现类继续实现Actions接口，lambda体放入performance里？
         */
        macro.record(() -> mobile.call());
        macro.record(() -> mobile.sms());
        macro.record(() -> System.out.println("Hello macro"));
        macro.run();
        
        mobile.check();
    }
    
    @Test
    public void lambdaAdvCommand() {
        Macro macro = new Macro();
        MockMobile mobile = new MockMobile();
        
        macro.record(mobile::call);
        macro.record(mobile::sms);
        macro.run();
        
        mobile.check();
    }
    
}

class MockMobile implements Mobile {

    private final List<String> actions = new ArrayList<>();

    @Override
    public void call() {
        actions.add("call");
    }

    @Override
    public void sms() {
        actions.add("sms");
    }

    public void check() {
        assertEquals("call", actions.get(0));
        assertEquals("sms", actions.get(1));
    }

}