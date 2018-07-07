package com.sample;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import static java.lang.System.out;

public class JOLSample_06_Gaps {

    public static void main(String args[]){
        out.println(VM.current().details());
        out.println(ClassLayout.parseClass(C.class).toPrintable());
    }

    public static class A{
        boolean a;
    }

    public static class B extends A{
        boolean b;
    }

    public static class C extends B{
        boolean c;
    }
}
