package com.sample;

import org.openjdk.jol.datamodel.X86_32_DataModel;
import org.openjdk.jol.datamodel.X86_64_COOPS_DataModel;
import org.openjdk.jol.datamodel.X86_64_DataModel;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.layouters.CurrentLayouter;
import org.openjdk.jol.layouters.HotSpotLayouter;
import org.openjdk.jol.layouters.Layouter;
/*
* 可以模拟在不同体系的cpu上的内存布局
* */
public class JOLSample_10_DataModels {

    public static void main(String args[]){
        Layouter l;
        l = new CurrentLayouter();
        System.out.println("***** " + l);
        System.out.println(ClassLayout.parseClass(A.class, l).toPrintable());
        l = new HotSpotLayouter(new X86_32_DataModel());
        System.out.println("*****" + l);
        System.out.println(ClassLayout.parseClass(A.class, l).toPrintable());
        l = new HotSpotLayouter(new X86_64_DataModel());
        System.out.println("*****" + l);
        System.out.println(ClassLayout.parseClass(A.class, l).toPrintable());
        l = new HotSpotLayouter(new X86_64_COOPS_DataModel());
        System.out.println("*****" + l);
        System.out.println(ClassLayout.parseClass(A.class, l).toPrintable());
    }

    public static class A{
        Object a;
        long b;
        Object c;
    }
}
