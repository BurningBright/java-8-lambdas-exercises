package cn.lcg.java8.chapter5;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
/**
 * @Description 测试自定义合并器、收集器
 *      将合并器的泛型设计的更复杂是否可以一步到位？
 * @author leon
 * @date 2016年4月19日 上午11:04:06
 */
public class TestUrlCombiner_Collector {
    
    @Test
    public void testUrlCombiner() {
        Map<String, String> arg = new HashMap<String, String>();
        arg.put("a", "11你");
        arg.put("b", "22我");
        arg.put("c", "33他");
        String result = arg.entrySet().stream()
                .reduce(new UrlCombiner("www.baidu.com", "/shit"), UrlCombiner::add, UrlCombiner::merge)
                .toString();
        System.out.print(result);
    }
    
    @Test
    public void testUrlCollector() {
        Map<String, String> a1 = new HashMap<String, String>();
        a1.put("a", "11你");
        a1.put("b", "22我");
        
        String ret1 = a1.entrySet().stream().collect(new UrlCollector("www.douban.com", "/music"));
        
        Map<String, String> a2 = new HashMap<String, String>();
        a2.put("c", "33他");
        a2.put("e", "44她");
        a2.put("f", ret1);
        
        String ret2 = a2.entrySet().stream().collect(new UrlCollector("www.baidu.com", "/play"));
        
        System.out.println(ret2);
    }
    
}
