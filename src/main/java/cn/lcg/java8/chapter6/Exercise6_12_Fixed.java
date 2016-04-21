package cn.lcg.java8.chapter6;

import org.openjdk.jmh.Main;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.RunnerException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;
/**
 * @Description 链表和数组表，在并行非并行，在不同的流下的基准对比
 * @author leon
 * @date 2016年4月21日 下午6:09:38
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
public class Exercise6_12_Fixed {

    public static void main(String[] ignore) throws RunnerException, IOException {
        final String[] args = {
                ".*Exercise6_12_Fixed.*",
                "-wi",
                "3",
                "-i",
                "3",
                "-f",
                "1"
        };
        Main.main(args);
    }

    private List<Integer> arrayListOfNumbers;
    private List<Integer> linkedListOfNumbers;

    @Setup
    public void init() {
        arrayListOfNumbers= new ArrayList<>();
        addNumbers(arrayListOfNumbers);

        linkedListOfNumbers = new LinkedList<>();
        addNumbers(linkedListOfNumbers);
    }

    private void addNumbers(List<Integer> container) {
        IntStream.range(0, 1_000_000)
                .forEach(container::add);
    }

    @Benchmark
    public int slowSumOfSquares() {
        return linkedListOfNumbers.parallelStream() // 13
                                  .map(x -> x * x)
                                  .reduce(0, (acc, x) -> acc + x);
    }

    @Benchmark
    public int serialSlowSumOfSquares() {
        return linkedListOfNumbers.stream()
                                  .map(x -> x * x) // 14
                                  .reduce(0, (acc, x) -> acc + x);
    }

    @Benchmark
    public int intermediateSumOfSquares() {
        return arrayListOfNumbers.parallelStream()  // 5
                                 .map(x -> x * x)
                                 .reduce(0, (acc, x) -> acc + x);
    }

    @Benchmark
    public int serialIntermediateSumOfSquares() {
        return arrayListOfNumbers.stream()
                                 .map(x -> x * x)   // 8
                                 .reduce(0, (acc, x) -> acc + x);
    }

    @Benchmark
    public int fastSumOfSquares() {
        return arrayListOfNumbers.parallelStream()  // 1
                                 .mapToInt(x -> x * x)
                                 .sum();
    }

    @Benchmark
    public int serialFastSumOfSquares() {
        return arrayListOfNumbers.stream()
                           .mapToInt(x -> x * x)    // 2
                           .sum();
    }
    
    @Benchmark
    public int serialReduceSumOfSquares() {         // 5
        return arrayListOfNumbers.stream()
                .reduce(0, (acc, x) -> acc + x * x);
    }
}
