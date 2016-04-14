package cn.lcg.java8.chapter2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;


import org.junit.Test;

import cn.lcg.java8.chapter1.Keeper;

/**
 * @Description 常用函数接口类
 * @author leon
 * @date 2016年4月13日 下午6:04:47
 */
public class FunctionInterfaceExercise {

    @Test
    public void testPredicate() {
        Predicate<Integer> justice = a -> a > 3;
        System.out.println(justice.test(5));
    }
    
    @Test
    public void testConsumer() {
        Consumer<String> sumer = world -> System.out.println(world);
        sumer.accept("Hello Consumer");
    }
    
    @Test
    public void testFunction() {
        Keeper xiaoHua = new Keeper("xiao hua", Arrays.asList(), Arrays.asList("shit"));
        
        Function<Keeper, String> name = keeper -> keeper.getName();
        assertEquals("xiao hua", name.apply(xiaoHua));
    }
    
    @Test
    public void testSupplier() {
        Supplier<String> sup = () -> "Hello";
        ThreadLocal<String> tl = ThreadLocal.withInitial(sup);
        assertEquals("Hello", tl.get());
    }
    
    @Test
    public void testUnaryOperator() {
        UnaryOperator<Boolean> uo = in -> !in;
        assert(uo.apply(false) == false);
    }
    
    @Test
    public void testBinaryOperator() {
        BinaryOperator<Long> bo = (a, b) -> a * b;
        System.out.println(bo.apply((long)123456, (long)654321));
    }
}
