package com.sample;

import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.vm.VM;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class JOLSample_22_Compaction {
    public static volatile Object sink;


    public static void main(String[] args) throws Exception {
        out.println(VM.current().details());
        // allocate some objects to beef up generations
        for (int c = 0; c < 1000000; c++) {
            sink = new Object();
        }
        System.gc();
        List<String> list = new ArrayList<String>();
        for (int c = 0; c < 1000; c++) {
            list.add("Key" + c);
        }
        for (int c = 1; c <= 10; c++) {
            GraphLayout.parseInstance(list).toImage("list-" + c + ".png");
            System.gc();
        }
    }
}
