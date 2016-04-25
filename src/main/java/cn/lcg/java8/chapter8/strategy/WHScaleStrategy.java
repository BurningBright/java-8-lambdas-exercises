package cn.lcg.java8.chapter8.strategy;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
/**
 * @Description 缩放图像（按高度和宽度缩放）
 *      bb 比例不对时是否需要补白：true为补白; false为不补白;
 * @author leon
 * @date 2016年4月24日 下午9:40:49
 */
public class WHScaleStrategy implements PictureScaleStrategy {
    
    public WHScaleStrategy(InputStream imageStreamIn, OutputStream imageStreamOut) {
        
    }
    
    public void scale(InputStream imageStreamIn, OutputStream imageStreamOut) {
        String fmt="png"; int height =100; int width=300; boolean bb=true;
        
        try {
            double ratio = 0.0; // 缩放比例
            BufferedImage bi = ImageIO.read(imageStreamIn);
            Image itemp = bi.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            // 计算比例
            if ((bi.getHeight() > height) || (bi.getWidth() > width)) {
                if (bi.getHeight() > bi.getWidth()) {
                    ratio = (new Integer(height)).doubleValue() / bi.getHeight();
                } else {
                    ratio = (new Integer(width)).doubleValue() / bi.getWidth();
                }
                AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(ratio, ratio), null);
                itemp = op.filter(bi, null);
            }
            if (bb) {// 补白
                BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                Graphics2D g = image.createGraphics();
                g.setColor(Color.white);
                g.fillRect(0, 0, width, height);
                if (width == itemp.getWidth(null))
                    g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2, itemp.getWidth(null),
                            itemp.getHeight(null), Color.white, null);
                else
                    g.drawImage(itemp, (width - itemp.getWidth(null)) / 2, 0, itemp.getWidth(null),
                            itemp.getHeight(null), Color.white, null);
                g.dispose();
                itemp = image;
            }
            ImageIO.write((BufferedImage) itemp, fmt, imageStreamOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    };
    
}
