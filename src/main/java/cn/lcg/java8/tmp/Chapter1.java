package cn.lcg.java8.tmp;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 
* @Description: 测试第一章
* @author leon
* @date 2016年3月4日 上午11:15:24
*
 */
public class Chapter1 extends SoftWareChapter {
    
    public List<String> getNameOfEngineers_Lambda() {
        return deves.stream().map(engineer -> engineer.getName())
                .collect(Collectors.toList());
    }
    
    public List<String> getNameOfEngineers_MethodReference() {
        return deves.stream().map(Engineer::getName)
                .collect(Collectors.toList());
    }
    
    public List<Engineer> getEngineerFromBlizzard() {
        return deves
                .stream()
                .filter(engineer -> "Blizzar".equalsIgnoreCase(engineer
                        .getCompany())).collect(Collectors.toList());
    }
}
