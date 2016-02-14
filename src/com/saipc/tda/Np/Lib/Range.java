package com.saipc.tda.Np.Lib;

/**
 * Created by schandramouli on 2/13/16.
 */
public class Range {
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
}
