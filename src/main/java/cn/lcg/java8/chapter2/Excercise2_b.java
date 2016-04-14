package cn.lcg.java8.chapter2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.text.DateFormatter;

/**
 * 
* @Description: ThreadLocal本地副本，线程隔离，空间换时间。
* @author leon
* @date 2016年3月4日 上午11:14:29
*
 */
public class Excercise2_b implements Runnable{
    
    private ThreadLocal<DateFormatter> tl;
    private Calendar cal;
    
    public Excercise2_b(ThreadLocal<DateFormatter> tl, Calendar cal) {
        this.tl = tl;
        this.cal = cal;
    }
    
    @Override
    public void run() {
        System.out.println(tl.get().getFormat().format(cal.getTime()));
    }
    
    public static void main(String[] args) {
        
        ThreadLocal<DateFormatter> formatter = ThreadLocal
                .withInitial(() -> new DateFormatter(new SimpleDateFormat(
                        "dd-MMM-yyyy", Locale.ENGLISH)));
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1970);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        
        Thread t1 = new Thread(new Excercise2_b(formatter, cal));
        
        Calendar cal_ = Calendar.getInstance();
        cal_.set(Calendar.YEAR, 1980);
        cal_.set(Calendar.MONTH, Calendar.JANUARY);
        cal_.set(Calendar.DAY_OF_MONTH, 1);
        Thread t2 = new Thread(new Excercise2_b(formatter, cal_));
//        Thread t2 = new Thread(() -> {System.out.println("2");});
        t1.start();
        t2.start();
    }

}