package cn.lcg.java8.chapter2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.GregorianCalendar;

/**
 * 
* @Description: 比较日历对象大小
* @author leon
* @date 2016年3月3日 下午6:54:26
*
 */
public class LambdaInGregorian {

	public static void main(String[] args) {
		int N = 10;
		GregorianCalendar[] gg = new GregorianCalendar[N];
		for(int i=0; i<N; i++) {
			gg[i] = new GregorianCalendar();
			gg[i].setTimeInMillis(System.currentTimeMillis()
					- (long) (Math.random() * 1000000));
			System.out.println(gg[i].getTime());
		}
		System.out.println(min(gg).getTime() + " <-");
	}

	public static <T extends Comparable<? super T>> T min(T[] array) {
		class A implements Comparator<T>{
			
			public int compare(T o1, T o2) {
				return o1.compareTo(o2);
			}
			
		}
		/*
		 *  由于是泛型方法无法知道具体的对比属性，
		 *  无法使用Comparator.comparing(keyExtractor)
		 *  使用内部类，通过实现比较器方法，外部构建比较者A。
		 */
		
		return Arrays.asList(array).stream().min(new A()).get();
	}
}
