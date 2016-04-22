package cn.lcg.java8.chapter8.command;
/**
 * @Description 具体命令，模拟一次电话指令
 * @author leon
 * @date 2016年4月22日 下午4:27:38
 */
public class Call implements Actions {
    
    private Mobile mobile;
    
    public Call(Mobile mobile) {
        this.mobile = mobile;
    }
    
    @Override
    public void perform() {
        mobile.call();
    }

}
