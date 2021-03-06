package com.saipc.tda.Np;

import com.saipc.tda.Np.Lib.Range;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

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
        Range z2 = new Range("15-24");
        Range z3 = new Range("19-29");

//        System.out.println(x.isOverlapping(y));
//        System.out.println(x.isOverlapping(z));

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
        ranges.add(z2);
        ranges.add(z3);
        System.out.println(ranges);
        // need to sort this according to the start times, and
        // then arrange them. Didnt know this was NP
        // what use is sorting? why do we need it?
        // Sorting might help us do fewer comparisons for overlap

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

        Range OverlappedRanges = new Range("0-0");
        // there are two variations of this, right?
        // so one is the Google one, which is in the other repo,
        // but this one is selecting the set that maximizes the
        // value => no of films acted. This is pretty similar
        // to Amazon

        // the first thing that comes to mind is that I can
        // do 2 for loops, go over each element, add it, then
        // see if other elements can be added. But for large datasets
        // this is O(n^2), completely unacceptable.

        // use the fact that its sorted to reduce the computes
        // for the overlapping thing. Create a hashmap with the
        // overlaps and the items, this will serve as a heuristic,
        // which can be used for selecting.
        int runs = 0;
        int max = 0;
        HashMap<Integer, ArrayList<Range>> rangeIntegerHashMap = new HashMap<>();
        for (int i = 0; i < ranges.size(); i++) {
            // kinda looks like n log n
            int count = 0;
            int j = i + 1;
            Range range = ranges.get(i);
            if (i != 0) {
                int k = i;
                while (k > 0 && range.isOverlapping(ranges.get(k - 1))) {
                    count++;
                    runs++;
                    k--;
                }
            }
            while (j < ranges.size() && range.isOverlapping(ranges.get(j))) {
                j++;
                count++;
                runs++;
            }
            if (rangeIntegerHashMap.containsKey(count)) {
                rangeIntegerHashMap.get(count).add(range);
            } else {
                ArrayList<Range> list = new ArrayList<>();
                list.add(range);
                rangeIntegerHashMap.put(count, list);
            }
            // update max
            max = Math.max(count, max);
        }

        System.out.println(rangeIntegerHashMap);
        System.out.println(runs);

        // now add the JUST the *first* one with least overlap
        // TODO: this is hard, but lets think of a way
        // quite obviously this can be extremely sparse,
        // so lets add a early exit condition
        //
        ArrayList<Range> rangesPotential = new ArrayList<>();
        // max = Math.min(max / 2, ranges.size() / 2);
        int overlaps = 0;
        for (int i = 0; i < max; i++) {
            if (! rangeIntegerHashMap.containsKey(i)) {
                continue;
            }
            // heuristic here: if the no of overlaps seen so far
            // is greater than the total number of elts, there
            // is no way to add more right?

            int j = 0;
            ArrayList<Range> tempRanges = rangeIntegerHashMap.get(i);
            while (j < tempRanges.size() && (overlaps + i) < ranges.size()) {
                overlaps += i;
                rangesPotential.add(tempRanges.get(j));
                j++;
            }
            overlaps += i * rangeIntegerHashMap.get(i).size();
        }

        System.out.println(rangesPotential);

    }
}
