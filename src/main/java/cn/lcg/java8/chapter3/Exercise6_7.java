package cn.lcg.java8.chapter3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

/**
 * @Description 6、7，字符串流操作
 * @author leon
 * @date 2016年4月14日 上午11:18:57
 */
public class Exercise6_7 {
    
    public static int countLowerCaseLetter(String str) {
        if(str == null) return 0;
        int result = (int) str.chars()
                .filter(letter -> letter >= 'a' && letter <= 'z').count();
        return result;
    }
    
    public static Optional<String> findMaxLengthString(String[] args) {
        Optional<String> result = Arrays.asList(args).stream()
                .max(Comparator.comparing(Exercise6_7::countLowerCaseLetter));
        // comparing 一定有段不堪回首的往事
        return result;
    }
}
