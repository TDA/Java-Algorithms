package com.saipc.tda.Np.Lib;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by schandramouli on 2/13/16.
 */
public class Range implements Comparable{
    long start;
    long end;

    public Range() {
        this.start = 0;
        this.end = 0;
    }

    public Range(long start, long end) {
        this.start = start;
        this.end = end;
    }

    public Range(String s) {
        String[] times = s.split("-");
        this.start = Long.parseLong(times[0]);
        this.end = Long.parseLong(times[1]);
    }

    public boolean isOverlapping(Range s) {
        // if either a ends before b or b ends
        // before a, then they are NOT overlapping,
        // else they are :O
        return !(this.end < s.start || this.start > s.end);
    }

    public static ArrayList<Range> sortRanges(ArrayList<Range> ranges) {
        ArrayList<Range> ranges1 = new ArrayList<>();
        //Collections.sort(ranges, );
        return ranges1;
    }
}
