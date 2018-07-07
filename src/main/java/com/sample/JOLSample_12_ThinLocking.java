package com.sample;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import static java.lang.System.out;
/*
* 可以从对象的头部清楚的看到对象锁的状态，具体hotspot的锁的实现在hotspot官网里可以找到
* 下面是轻量级锁的头部
* */
public class JOLSample_12_ThinLocking {
    public static void main(String args[]){
        out.println(VM.current().details());
        final A a = new A();
        ClassLayout layout = ClassLayout.parseInstance(a);

        out.println("***** Fresh Object");
        out.println(layout.toPrintable());
        synchronized (a){
            out.println("***** With the lock");
            out.println(layout.toPrintable());
        }

        out.println("***** After the lock");
        out.println(layout.toPrintable());
    }

    public static class A{

    }
}
