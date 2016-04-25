package cn.lcg.java8.chapter8.template;
/**
 * @Description 认证异常
 * @author leon
 * @date 2016年4月25日 下午2:35:12
 */
public class ApplicationDenied extends Exception {

    public ApplicationDenied(String string) {
        super(string);
    }

    /**
     * 
     */
    private static final long serialVersionUID = -7923160554319466114L;

}
