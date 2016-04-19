package cn.lcg.java8.chapter5;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map.Entry;
/**
 * @Description Url地址合并器
 *      添加、合并、结果，是收集器的基础
 * @author leon
 * @date 2016年4月19日 上午11:03:08
 */
public class UrlCombiner {
    
    private final String domain;
    private final String address;
    private final StringBuilder builder;
    
    public UrlCombiner(String domain, String address) {
        this.domain = domain;
        this.address = address;
        builder = new StringBuilder();
    }
    
    private boolean isAtStart() {
        return builder.length() == 0;
    }
    
    public UrlCombiner add(Entry<String, String> en) {
        if(isAtStart()) {
            builder.append("http://").append(domain).append(address).append("?");
        } else {
            builder.append("&");
        }
        try {
            builder.append(URLEncoder.encode(en.getKey(), "UTF-8")).append("=")
                    .append(URLEncoder.encode(en.getValue(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return this;
    }
    
    public UrlCombiner merge(UrlCombiner other) {
        builder.append(other);
        return this;
    }
    
    public String toString() {
        return builder.toString();
    }
    
}
