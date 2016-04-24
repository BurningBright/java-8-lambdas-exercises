package cn.lcg.java8.chapter8.strategy;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.junit.Test;

import com.insightfullogic.java8.examples.chapter2.ArrayExample;
import com.insightfullogic.java8.examples.chapter8.strategy.Compressor;
import com.insightfullogic.java8.examples.chapter8.strategy.ZipCompressionStrategy;

public class TestScaleStrategy {
    
    @Test
    public void testScale(){
        URL url = ArrayExample.class.getResource("Function.png");
        String src = url.getPath().substring(1);
        String ret = url.getPath().substring(1).replace("Function.png", "Function_1.png");
//        System.out.println(src);
//        System.out.println(ret);
//        PictureScaleStrategy.scale(src, ret, "png", 1.5, true);
    }
    
    @Test
    public void testZip(){
        Compressor c = new Compressor(new ZipCompressionStrategy());
        Path p = FileSystems.getDefault().getPath("C:\\Users\\Chen\\Desktop\\windows.cpp");
        try {
            c.compress(p, new File("C:\\Users\\Chen\\Desktop\\xxx.zip"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
