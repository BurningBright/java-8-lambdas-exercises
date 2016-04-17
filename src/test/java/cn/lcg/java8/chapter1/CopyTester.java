package cn.lcg.java8.chapter1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
/**
 * @Description 测试结构体中的重新创建的重要性
 * @author leon
 * @date 2016年4月17日 下午9:29:54
 */
public class CopyTester {
    
    @Test
    public void testCopy() {
        Keeper copyPython = SimpleData.pythonGroup.copy();
//        SimpleData.pythonGroup.setMainJob("shit");
        assertEquals(SimpleData.pythonGroup.getMainJob(), copyPython.getMainJob());
        assertSame(SimpleData.pythonGroup.getMainJob(), copyPython.getMainJob());
    }
    
    @Test
    public void testStruct() {
        List<String> jobs = Arrays.asList("clean", "play");
        Keeper wuWu = new Keeper("wu wu", new ArrayList<Keeper>(), jobs);
        jobs.set(0, "shit");
        assertNotEquals(wuWu.getMainJob(), jobs.get(0));
    }
    
}
