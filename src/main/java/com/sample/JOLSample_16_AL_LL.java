package com.sample;

import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.vm.VM;

import java.awt.print.Pageable;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;

import static java.lang.System.out;

public class JOLSample_16_AL_LL {
    public static void main(String args[]){
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
        pw.println(GraphLayout.parseInstance(al).toFootprint());
        pw.println(GraphLayout.parseInstance(ll).toFootprint());
        pw.println(GraphLayout.parseInstance(al, ll).toFootprint());
        pw.close();
    }
}
