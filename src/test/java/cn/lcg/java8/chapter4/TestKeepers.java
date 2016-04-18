package cn.lcg.java8.chapter4;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.lcg.java8.chapter1.SimpleData;

/**
 * @Description 测试动物管理员们的获取姓名正确，Optional是个好东西
 * @author leon
 * @date 2016年4月18日 上午9:35:48
 */
public class TestKeepers {
    
    @Test
    public void testGetName() {
        Keepers ks = new Keepers(SimpleData.getThreeKeeperList());
        String name1 = ks.getKeeperName(-1);
        assertEquals("unknow", name1);
        String name2 = ks.getKeeperName(2);
        assertEquals("dolphin group", name2);
    }
    
}
