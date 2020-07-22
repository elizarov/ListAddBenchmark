## Benchmark for adding to the end of the list

Java `ArrayList` vs Clojure persistent list.

See [sources here](src/main/java/benchmark/ListBenchmark.java).

```text         
# VM version: JDK 11.0.5, Java HotSpot(TM) 64-Bit Server VM, 11.0.5+10-LTS

Benchmark                                Score    Error  Units
ListBenchmark.testAddToArrayList       539.794 ± 17.975  us/op
ListBenchmark.testAddToClojureList     568.811 ± 31.657  us/op
ListBenchmark.testIterateArrayList     589.566 ± 22.695  us/op
ListBenchmark.testIterateClojureList  1098.466 ± 29.489  us/op
```