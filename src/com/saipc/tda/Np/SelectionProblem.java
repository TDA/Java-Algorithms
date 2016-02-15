package com.saipc.tda.Np;

import com.saipc.tda.Np.Lib.Range;

import java.util.ArrayList;

/**
 * Created by schandramouli on 2/13/16.
 */
public class SelectionProblem {
    public static void main(String[] args) {
        // given a set of time ranges, output the
        // non-overlapping ranges
        Range r = new Range(0, 7);
        Range s = new Range("1-5");
        Range t = new Range("3-9");
        Range u = new Range("8-12");
        Range v = new Range("7-10");
        Range w = new Range("11-19");
        Range x = new Range("13-18");
        Range y = new Range("16-25");
        Range z = new Range("19-25");

        System.out.println(x.isOverlapping(y));
        System.out.println(x.isOverlapping(z));

        ArrayList<Range> ranges = new ArrayList<>();
        ranges.add(r);
        ranges.add(s);
        ranges.add(t);
        ranges.add(u);
        ranges.add(v);
        ranges.add(w);
        ranges.add(x);
        ranges.add(y);
        ranges.add(z);
        // need to sort this according to the start times, and
        // then arrange them. Didnt know this was NP
        // Also wrote like 300 lines of Python today to a
        // private repo, so its fine if i just add docs
        // here :P :D
    }
}
