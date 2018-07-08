package com.sample;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.vm.VM;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;

import static java.lang.System.out;
/*
* 获取指定对象的所有可达对象
* */
public class JOLSample_16_AL_LL {
    public static void main(String args[]) throws Exception{
        out.println(VM.current().details());
        ArrayList<Integer> al = new ArrayList<Integer>();
        LinkedList<Integer> ll = new LinkedList<Integer>();
        for(int i = 0; i<1000; i++){
            Integer io = i;
            al.add(io);
            ll.add(io);
        }
        al.trimToSize();
        PrintWriter pw = new PrintWriter(out);
        A a = new A();
        pw.println(GraphLayout.parseInstance(a).toFootprint());//获取所有可达对象
        pw.println(ClassLayout.parseInstance(al).toPrintable());
        pw.println(GraphLayout.parseInstance(al).toFootprint());
        pw.println(GraphLayout.parseInstance(ll).toFootprint());
        pw.println(GraphLayout.parseInstance(al, ll).toFootprint());
        pw.close();
    }

    public static class A{
        int a = 0;
        Object o1 = new Object();
        Object o2 = new Object();
        Object o3 = new B();
    }

    public static class B{
        Object a;
    }
}
