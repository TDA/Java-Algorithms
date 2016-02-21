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
        Range z1 = new Range("19-22");

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
        ranges.add(z1);
        System.out.println(ranges);
        // need to sort this according to the start times, and
        // then arrange them. Didnt know this was NP

        ranges = Range.sortRanges(ranges);
        System.out.println(ranges);

        // Also wrote like 300 lines of Python today to a
        // private repo, so its fine if i just add docs
        // here :P :D

        // here we run into a problem: do we start at
        // the beginning and add times discarding new overlaps?
        // this has now reduced to a knapsack basically, we need
        // to maximize the no of items selected, while having
        // them non-overlap
        // im thinking i can create a hashmap with the overlaps
        // for each range, quite obviously, a range can only overlap
    }
}
