package com.sample;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import static java.lang.System.out;
/*
* 输出对象在内存中的布局
* */
public class JOLSample_02_Alignment {
    public static void main(String args[]){
        out.println(VM.current().details());
        out.println(ClassLayout.parseClass(A.class).toPrintable());
    }
    public static class A{
        long f;
    }
}
