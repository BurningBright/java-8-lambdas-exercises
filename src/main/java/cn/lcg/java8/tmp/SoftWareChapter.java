package cn.lcg.java8.tmp;

import java.util.ArrayList;
import java.util.List;

/**
 * 
* @Description: 额外抽象的软件领域
* @author leon
* @date 2016年3月4日 上午11:15:57
*
 */
public abstract class SoftWareChapter {
    
    protected final List<Engineer> deves;
    protected final List<Platform> plats;
    
    public SoftWareChapter() {
        deves = new ArrayList<>();
        plats = new ArrayList<>();
        loadData("");
    }
    
    private void loadData(String file) {
        
    }
}
