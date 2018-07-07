package com.sample;

import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.vm.VM;
import sun.reflect.generics.scope.DummyScope;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

public class JOLSample_18_Layouts {
    public static void main(String args[]){
        out.println(VM.current().details());
        PrintWriter pw = new PrintWriter(System.out, true);
        Map<Dummy, Void> map = new HashMap<Dummy, Void>();
        map.put(new Dummy(1), null);
        map.put(new Dummy(2), null);

        System.gc();
        pw.println(GraphLayout.parseInstance(map).toPrintable());
        for(int c = 0;c < 12; c++){
            map.put(new Dummy(2), null);
        }

        System.gc();
        pw.println(GraphLayout.parseInstance(map).toPrintable());
        pw.close();
    }

    public static class Dummy implements Comparable<Dummy>{
        static int ID;
        final int id = ID++;
        final int hc;
        public Dummy(int hc){
            this.hc = hc;
        }

        public boolean equals(Object o){
            return (this == o);
        }

        public int hashCode(){
            return hc;
        }

        public int compareTo(Dummy o){
            return (id < o.id) ? -1 : ((id == o.id) ? 0 : 1);
        }
    }
}
