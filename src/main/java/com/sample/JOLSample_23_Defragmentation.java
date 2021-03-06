package com.sample;

import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.vm.VM;

import static java.lang.System.out;

public class JOLSample_23_Defragmentation {
    public static volatile Object sink;


    public static void main(String[] args) throws Exception {
        out.println(VM.current().details());
        // allocate some objects to beef up generations
        /*for (int c = 0; c < 1000000; c++) {
            sink = new Object();
        }*/
        //System.gc();
        final int COUNT = 10000;
        Object[] array = new Object[COUNT];
        for (int c = 0; c < COUNT; c++) {
            array[c] = new Object();
        }
        Object obj = array;
        GraphLayout.parseInstance(obj).toImage("array-1-new.png");
        for (int c = 2; c <= 5; c++) {
            System.gc();
            GraphLayout.parseInstance(obj).toImage("array-" + c + "-before.png");
        }
        for (int c = 0; c < COUNT; c++) {
            if (Math.random() < 0.5) {
                array[c] = null;
            }
        }
        GraphLayout.parseInstance(obj).toImage("array-6-after.png");
        for (int c = 7; c <= 10; c++) {
            System.gc();
            GraphLayout.parseInstance(obj).toImage("array-" + c + "-after-gc.png");
        }
    }
}
