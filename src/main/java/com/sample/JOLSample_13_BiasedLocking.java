package com.sample;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import java.util.concurrent.TimeUnit;

import static java.lang.System.out;
/*
* 这个例子是查看偏向锁时对象头部值，
* */
public class JOLSample_13_BiasedLocking {

    public static void main(String[] args) throws Exception{
        out.println(VM.current().details());
        //TimeUnit.SECONDS.sleep(6);
        final A a = new A();
        ClassLayout layout = ClassLayout.parseInstance(a);
        out.println("**** Fresh object");
        out.println(layout.toPrintable());
        synchronized (a){
            out.println("***** With the lock");
            out.println(layout.toPrintable());
        }
        out.println("***** After the lcok");
        out.println(layout.toPrintable());
    }

    public static class A{

    }
}
