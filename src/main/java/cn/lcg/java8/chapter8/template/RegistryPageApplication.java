package cn.lcg.java8.chapter8.template;
/**
 * @Description 注册页面，作为基础页的子类可绑定验证函数
 * @author leon
 * @date 2016年4月25日 下午3:12:12
 */
public class RegistryPageApplication extends PageApplication {

    public RegistryPageApplication(Registry registry) {
        super(registry::emailUniqueIdentity, 
                registry::passwordAuth, 
                registry::verifyCodeAuth);
    }

}
