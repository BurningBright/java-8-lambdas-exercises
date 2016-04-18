package cn.lcg.java8.chapter1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;
/**
 * @Description 简单数据
 * @author leon
 * @date 2016年4月17日 下午9:31:01
 */
public class SimpleData {
    
    public static final Keeper zhangSan = new Keeper("zhang san", new ArrayList<Keeper>(), Arrays.asList("feed", "clean"));
    public static final Keeper liSi = new Keeper("li si", new ArrayList<Keeper>(), Arrays.asList("feed", "play"));
    public static final Keeper wangWu = new Keeper("wang wu", new ArrayList<Keeper>(), Arrays.asList("clean", "play"));
    
    public static final Keeper maYi = new Keeper("ma yi", new ArrayList<Keeper>(), Arrays.asList("feed", "water"));
    public static final Keeper maEr = new Keeper("ma er", new ArrayList<Keeper>(), Arrays.asList("clean"));
    public static final Keeper maSan = new Keeper("ma san", new ArrayList<Keeper>(), Arrays.asList("play", "feed"));
    public static final Keeper maSi = new Keeper("ma si", new ArrayList<Keeper>(), Arrays.asList("water"));
    public static final Keeper maWu = new Keeper("ma wu", new ArrayList<Keeper>(), Arrays.asList("arrange"));
    public static final Keeper maLiu = new Keeper("ma liu", new ArrayList<Keeper>(), Arrays.asList("clean", "arrange"));
    
    public static final Keeper zhaoYun = new Keeper("zhao yun", new ArrayList<Keeper>(), Arrays.asList("feed"));
    public static final Keeper guanYu = new Keeper("guan yu", new ArrayList<Keeper>(), Arrays.asList("clean"));
    public static final Keeper zhouXun = new Keeper("zhou xun", new ArrayList<Keeper>(), Arrays.asList("feed", "clean"));
    
    public static final Keeper pythonGroup = new Keeper("python group", Arrays.asList(zhangSan, liSi, wangWu),
            Arrays.asList("feed", "clean", "play"));
    public static final Keeper tigerGroup = new Keeper("tiger group",
            Arrays.asList(maYi, maEr, maSan, maSi, maWu, maLiu),
            Arrays.asList("feed", "water", "clean", "play", "arrange"));
    public static final Keeper dolphinGroup = new Keeper("dolphin group", Arrays.asList(liSi, maLiu),
            Arrays.asList("feed", "play", "clean", "arrange"));
    public static final Keeper horseGroup = new Keeper("horse group", Arrays.asList(zhaoYun, guanYu),
            Arrays.asList("feed","clean"));
    
    public static final Animal python = new Animal("Molurus python", getDate("2015-04-14"), 1);
    public static final Animal tiger = new Animal("Malaysia tiger", getDate("2013-04-14"), 3);
    public static final Animal dolphin = new Animal("Grey dolphin", getDate("2014-04-14"), 2);
    
    public static final Animal horse = new Animal("Mongolian horse", getDate("2013-04-17"), 3);
    public static final Animal deer = new Animal("Sika deer", getDate("2014-04-17"), 2);
    
    public static final Zoo hzZoo = new Zoo("hangzhou zoo", Arrays.asList(python, tiger, dolphin), Arrays.asList(pythonGroup, tigerGroup, dolphinGroup));
    public static final Zoo shZoo = new Zoo("shanghai zoo", Arrays.asList(horse, deer, python), Arrays.asList(horseGroup, zhouXun, pythonGroup));
    
    public static Date getDate(String d) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static Stream<Keeper> getThreeKeepers() {
        return Stream.of(pythonGroup, tigerGroup, dolphinGroup);
    }
    public static List<Keeper> getThreeKeeperList() {
        return Arrays.asList(pythonGroup, tigerGroup, dolphinGroup);
    }
    public static Stream<Keeper> getTwoKeepers() {
        return Stream.of(pythonGroup, zhouXun);
    }
    public static List<Keeper> getTwoKeeperList() {
        return Arrays.asList(pythonGroup, zhouXun);
    }
    
    public static Stream<Zoo> getTwoZoos() {
        return Stream.of(hzZoo, shZoo);
    }
    public static List<Zoo> getTwoZooList() {
        return Arrays.asList(hzZoo, shZoo);
    }
}
