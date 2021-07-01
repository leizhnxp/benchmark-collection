package me.leizh.benchmark.list;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jmh.annotations.*;

import java.util.*;

@State(Scope.Thread)
@BenchmarkMode(Mode.SingleShotTime)
@Fork
@Slf4j
public class ListMidAddCum {

    @Param(value = {"10000","100000","200000"})
    private int length;

    private void insertMid(List<String> list){
        int size = list.size();
        list.add(size/2,value);
    }

    private String value = "";

    @Benchmark
    public void arrayList() {
        ArrayList<String> target = new ArrayList<>();
        for(int i=0;i<length;i++){
            insertMid(target);
        }
        this.collection = target;
    }

    @Benchmark
    public void treeSet() {
        TreeSet<Integer> target = new TreeSet<>();
        for(int i=0;i<length;i++){
            target.add(i*2);
            target.add(i);
        }
        this.collection = target;
    }

    @Benchmark
    public void linkedList() {
        LinkedList<String> target = new LinkedList<>();
        for(int i=0;i<length;i++){
            insertMid(target);
        }
        this.collection = target;
    }

    @TearDown
    public void tearDown(){
        log.info("{},{}", collection.getClass(), collection.size());
    }

    private Collection collection;
}
