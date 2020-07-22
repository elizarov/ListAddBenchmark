package benchmark;

import clojure.lang.IPersistentCollection;
import clojure.lang.ISeq;
import clojure.lang.PersistentList;
import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@Measurement(iterations = 10, time = 1)
@Warmup(iterations = 5, time = 1)
@Fork(1)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class ListBenchmark {
    private static final int n = 100_000;
    
    @Benchmark
    public ArrayList<Integer> testAddToArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        return list;
    }

    @Benchmark
    public IPersistentCollection testAddToClojureList() {
        IPersistentCollection list = PersistentList.EMPTY;
        for (int i = 0; i < n; i++) {
            list = list.cons(i);
        }
        return list;
    }

    @Benchmark
    public int testIterateArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int sum = 0;
        for (int x: list) {
            sum += x;
        }
        return sum;
    }

    @Benchmark
    public int testIterateClojureList()  {
        IPersistentCollection list = PersistentList.EMPTY;
        for (int i = 0; i < n; i++) {
            list = list.cons(i);
        }
        ISeq cur = list.seq();
        int sum = 0;
        while (cur != null) {
            sum += (Integer)cur.first();
            cur = cur.next();
        }
        return sum;
    }
}
