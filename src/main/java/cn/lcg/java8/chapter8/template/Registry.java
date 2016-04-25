package cn.lcg.java8.chapter8.template;

import java.util.regex.Pattern;
/**
 * @Description 注册主体
 * @author leon
 * @date 2016年4月25日 下午3:11:46
 */
public class Registry {
    
    public void emailUniqueIdentity(String email) throws ApplicationDenied {
        Pattern p = Pattern.compile("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$");
        if(!p.matcher(email).matches()) {
            throw new ApplicationDenied("email format error");
        }
    }
    
    public void passwordAuth(String passwd) throws ApplicationDenied {
        
        Pattern p1 = Pattern.compile("^[a-zA-Z0-9]{6,}$");
        Pattern p2 = Pattern.compile("[a-z]");
        Pattern p3 = Pattern.compile("[A-Z]");
        Pattern p4 = Pattern.compile("[0-9]");
        
        if(!p1.matcher(passwd).matches()) {
            throw new ApplicationDenied("password format error");
        }
        if(!p2.matcher(passwd).find()) {
            throw new ApplicationDenied("password need little case");
        }
        if(!p3.matcher(passwd).find()) {
            throw new ApplicationDenied("password need upper case");
        }
        if(!p4.matcher(passwd).find()) {
            throw new ApplicationDenied("password need number");
        }
        
    }
    
    public void verifyCodeAuth(String verify)  throws ApplicationDenied {
        if(verify != "123456") {
            throw new ApplicationDenied("verify code error");
        }
    }
    
}
