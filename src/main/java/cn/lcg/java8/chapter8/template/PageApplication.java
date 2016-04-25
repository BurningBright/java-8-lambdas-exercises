package cn.lcg.java8.chapter8.template;
/**
 * @Description lambda形式的模版，直接抽象构造
 * @author leon
 * @date 2016年4月25日 下午2:35:33
 */
public class PageApplication {
    private final Criteria emailUniqueIdentity;
    private final Criteria passwordAuth;
    private final Criteria verifyCodeAuth;
    
    public PageApplication(Criteria emailUniqueIdentity, Criteria passwordAuth, Criteria verifyCodeAuth) {
        this.emailUniqueIdentity = emailUniqueIdentity;
        this.passwordAuth = passwordAuth;
        this.verifyCodeAuth = verifyCodeAuth;
    }
    
    public void checkPageApplication(String email, String passwd, String verify) throws ApplicationDenied {
        emailUniqueIdentity.check(email);
        passwordAuth.check(passwd);
        verifyCodeAuth.check(verify);
        reportAuth();
    }
    
    private void reportAuth() {
        System.out.println("finish authentication");
    }
    
}
