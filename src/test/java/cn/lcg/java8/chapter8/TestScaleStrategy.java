package cn.lcg.java8.chapter8;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.insightfullogic.java8.examples.chapter8.OpenClosedPrinciple;

import cn.lcg.java8.chapter8.strategy.RatioScaleStrategy;
import cn.lcg.java8.chapter8.strategy.Scaling;
import cn.lcg.java8.chapter8.strategy.WHScaleStrategy;
/**
 * @Description 测试缩放策略模式
 * @author leon
 * @date 2016年4月25日 上午10:33:31
 */
public class TestScaleStrategy {
    
    @Test
    public void testScale(){
        
        File src = new File(OpenClosedPrinciple.class.getResource("strategy.png").getPath().substring(1));
        File rRo = new File(OpenClosedPrinciple.class.getResource("strategy.png").getPath().substring(1)
                .replace("strategy.png", "strategy_ro.png"));
        File rWh = new File(OpenClosedPrinciple.class.getResource("strategy.png").getPath().substring(1)
                .replace("strategy.png", "strategy_wh.png"));
        
//        Scaling s1 = new Scaling(new RatioScaleStrategy());
        Scaling s1 = new Scaling(new RatioScaleStrategy(null, null));
        Scaling s2 = new Scaling(new WHScaleStrategy(null, null));
        try {
            s1.scale(src, rRo);
            s2.scale(src, rWh);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testZip(){
//        Compressor c = new Compressor(new ZipCompressionStrategy());
//        Path p = FileSystems.getDefault().getPath("C:\\Users\\Administrator\\Desktop\\JDK_API_1_6_zh_CN.CHM");
//        try {
//            c.compress(p, new File("C:\\Users\\Administrator\\Desktop\\JDK_API_1_6_zh_CN.CHM.zip"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    
}
