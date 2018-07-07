package com.sample;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import static java.lang.System.out;
/*
* 对象的hashCode一旦被计算后就会存在对象的头部
* */
public class JOLSample_15_IdentityHashCode {

    public static void main(String args[]){
        out.println(VM.current().details());
        final A a = new A();
        ClassLayout layout = ClassLayout.parseInstance(a);
        out.println("**** Fresh object");
        out.println(layout.toPrintable());

        out.println("hashCode: " + Integer.toHexString(a.hashCode()));
        out.println();
        out.println("***** After identityHashCode()");
        out.println(layout.toPrintable());
    }

    public static class A{

    }
}
