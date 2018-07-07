package com.sample;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import static java.lang.System.out;
/*
* 输出对象的大小
* */
public class JOLSample_01_Basic {
    public static void main(String[] args){
        out.println(VM.current().details());
        out.println(ClassLayout.parseClass(A.class));
    }

    public static class A{
        boolean f;
    }
}
