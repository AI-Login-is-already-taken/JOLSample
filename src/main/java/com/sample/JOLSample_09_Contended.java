package com.sample;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;
import sun.misc.Contended;

import static java.lang.System.out;
/*
* 需要添加-XX:-RestrictContended
* 被@Contended注释的属性会被放在一个独立的缓存行中
* */
public class JOLSample_09_Contended {

    public static void main(String args[]){
        out.println(VM.current().details());
        out.println(ClassLayout.parseClass(C.class).toPrintable());
    }
    public static class A{
        @Contended
        int a;
        @Contended
        int b;
        @Contended
        int c;
        @Contended
        int d;
    }

    public static class C extends A{
        int e;
    }
}
