package com.sample;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import static java.lang.System.out;
/*
* 查看对象的头部
* 在Hotspot中，对象的头部包含两部分：mark word，class word，
* 我们可以清楚的看到下面两个测试中java层面语法一致的两个类其中不同的部分就是class word
* 相同的部分就是mark word;而且可以清楚的看到对象的属性值以及偏移量
* */
public class JOLSample_11_ClassWord {

    public static void main(String args[]){
        out.println(VM.current().details());
        out.println(ClassLayout.parseInstance(new A()).toPrintable());
        out.println(ClassLayout.parseInstance(new B()).toPrintable());
        out.println(ClassLayout.parseInstance(new C()).toPrintable());
    }

    public static class A{

    }

    public static class B{

    }

    public static class C{
        int a = 0;
    }
}
