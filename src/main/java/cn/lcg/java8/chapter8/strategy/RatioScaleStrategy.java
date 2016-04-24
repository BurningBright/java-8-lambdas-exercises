package cn.lcg.java8.chapter8.strategy;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * @Description 缩放图像（按比例缩放）
 *      flag 缩放选择:true 放大; false 缩小
 * @author leon
 * @date 2016年4月24日 下午9:40:03
 */
public class RatioScaleStrategy implements PictureScaleStrategy {
    
    public void scale(String srcImageFile, String result) {
        String fmt="png"; double scale=1.5; boolean flag=true;
        
        try {
            BufferedImage src = ImageIO.read(new File(srcImageFile)); // 读入文件
            int width = src.getWidth();     // 得到源图宽
            int height = src.getHeight();   // 得到源图长
            if (flag) {     // 放大
                width = (int) (width * scale);
                height = (int) (height * scale);
            } else {        // 缩小
                width = (int) (width / scale);
                height = (int) (height / scale);
            }
            Image image = src.getScaledInstance(width, height, Image.SCALE_DEFAULT);
            BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics g = tag.getGraphics();
            g.drawImage(image, 0, 0, null); // 绘制缩小后的图
            g.dispose();
            ImageIO.write(tag, fmt, new File(result));// 输出到文件流
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
