package cn.lcg.java8.chapter8.template;
/**
 * @Description 页面认证标准接口，用于标定函数名和参数签名
 * @author leon
 * @date 2016年4月25日 下午2:34:48
 */
public interface Criteria {
    
    public void check(String arg) throws ApplicationDenied;
    
}
