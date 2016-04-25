package cn.lcg.java8.chapter8.strategy;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Description 用于图片缩放
 * @author leon
 * @date 2016年4月24日 下午9:18:11
 */
public interface PictureScaleStrategy {
    
    public void scale(InputStream imageStreamIn, OutputStream imageStreamOut);
    
    /**
     * 缩放图像（按比例缩放）
     * @param srcImageFile 源图像文件地址
     * @param result 缩放后的图像地址
     * @param fmt 输出格式
     * @param scale 缩放比例
     * @param flag 缩放选择:true 放大; false 缩小;
     */
    //public void scale(String srcImageFile, String result, String fmt, double scale, boolean flag){};
    
    /**
     * 缩放图像（按高度和宽度缩放）
     * @param srcImageFile 源图像文件地址
     * @param result 缩放后的图像地址
     * @param fmt 输出格式
     * @param height 缩放后的高度
     * @param width 缩放后的宽度
     * @param bb 比例不对时是否需要补白：true为补白; false为不补白;
     */
//    public void scale(String srcImageFile, String result, String fmt, int height, int width, boolean bb){};
    
}
