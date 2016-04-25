package cn.lcg.java8.chapter8;

import org.junit.Test;

import cn.lcg.java8.chapter8.template.ApplicationDenied;
import cn.lcg.java8.chapter8.template.Registry;
import cn.lcg.java8.chapter8.template.RegistryPageApplication;
/**
 * @Description 测试模版方法，用主体类打包方法，作为参数传入构造
 * @author leon
 * @date 2016年4月25日 下午3:20:12
 */
public class TestRegistryTemplate {
    
    @Test
    public void testTemplate() {
        RegistryPageApplication rpa = new RegistryPageApplication(new Registry());
        try {
            rpa.checkPageApplication("qq@qq.com", "aA123456", "123456");
        } catch (ApplicationDenied e) {
            e.printStackTrace();
        }
    }
    
}
