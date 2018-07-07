package com.sample;

import org.openjdk.jol.vm.VM;

import java.io.PrintWriter;

import static java.lang.System.out;
/*
* 查看对象在内存中的地址，，可以看到地址的增长是线性的因为并行垃圾回收算法的分配策略是线性的，
* 但是可以发现在增长到某一个值是会退回来。。那是因为分配的代（存活区）发生了变化
* */
public class JOLSample_17_Allocation {
    public static void main(String args[]){
        out.println(VM.current().details());
        PrintWriter pw = new PrintWriter(out, true);
        long last = VM.current().addressOf(new Object());
        for(int i = 0; i < 1000 * 1000 * 1000; i++){
            long current = VM.current().addressOf(new Object());
            long distance = Math.abs(current - last);
            if(distance > 16 * 1024){
                pw.printf("Jumping from %x to %x (distance = %d bytes, %dk, %dM)%n",
                        last,
                        current,
                        distance,
                        distance/1024,
                        distance/1024/1024);
            }
            last = current;
        }
        pw.close();
    }
}
