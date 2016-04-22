package cn.lcg.java8.chapter8.command;
/**
 * @Description 具体命令，模拟一次短信指令
 * @author leon
 * @date 2016年4月22日 下午4:28:48
 */
public class Sms implements Actions {
    
    private Mobile mobile;
    
    public Sms(Mobile mobile) {
        this.mobile = mobile;
    }
    
    @Override
    public void perform() {
        mobile.sms();
    }

}
