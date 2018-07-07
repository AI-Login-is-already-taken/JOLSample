package com.sample;

import com.sun.org.apache.bcel.internal.generic.ClassObserver;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import static java.lang.System.out;
/*
*关于有继承关系的对象在内存中的存储，，，注意：父类与子类之间的属性的相对顺序不会被VM为节省内存空间的目地而调整
* */
public class JOLSample_04_Inheritance {

    public static void main(String args[]){
        out.println(VM.current().details());
        out.println(ClassLayout.parseClass(C.class).toPrintable());
    }

    public static class A{
        long a;
    }

    public static class B extends A{
        int b;
    }

    public static class C extends B{
        int c;
    }
}
