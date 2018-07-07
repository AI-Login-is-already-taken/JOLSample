package com.sample;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import static java.lang.System.out;
/*
* 父类与子类之间的属性的相对顺序不会被VM为节省内存空间的目地而调整
* */
public class JOLSample_05_InheritanceBarrier {

    public static void main(String args[]){
        out.println(VM.current().details());
        out.println(ClassLayout.parseClass(C.class).toPrintable());
    }

    public static class A{
        long a;
    }

    public static class B extends A{
        long b;
    }

    public static class C extends B{
        long c;
        int d;
    }
}
