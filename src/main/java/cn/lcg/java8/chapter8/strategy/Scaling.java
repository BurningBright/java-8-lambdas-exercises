package cn.lcg.java8.chapter8.strategy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Description 具体的缩放者
 * @author leon
 * @date 2016年4月24日 下午10:22:37
 */
public class Scaling {
    
    private PictureScaleStrategy pss;
    
    public Scaling(PictureScaleStrategy pss) {
        this.pss = pss;
    }
    
    public void scale(File in, File out) throws IOException {
        try (InputStream inStream = new FileInputStream(in);
                OutputStream outStream = new FileOutputStream(out)) {
            pss.scale(inStream, outStream);
        }
    }
    
}
