package com.sample;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import static java.lang.System.out;
/*
* transient修饰的字段不会被显示，，因为是属于vm内部字段
* */
public class JOLSample_07_Exceptions {
    public static void main(String args[]){
        out.println(VM.current().details());
        out.println(ClassLayout.parseClass(Throwable.class).toPrintable());
        Throwable h = new Throwable();
        h.fillInStackTrace();
        try {
            h.getClass().getDeclaredField("backtrace");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
