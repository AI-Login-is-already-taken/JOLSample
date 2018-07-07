package com.sample;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import static java.lang.System.out;
/*
* 对象属性在内存中的排列顺序会被调整
* */
public class JOLSample_03_Packing {
    public static void main(String args[]){
        out.println(VM.current().details());
        out.println(ClassLayout.parseClass(A.class).toPrintable());
    }

    public static class A{
        boolean bo1,bo2;
        byte b1, b2;
        char c1,c2;
        double d1,d2;
        float f1,f2;
        int i1,i2;
        long l1,l2;
        short s1,s2;
    }
}
