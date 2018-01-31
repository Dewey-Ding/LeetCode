package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals_56 {
    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(2, 3));
        intervals.add(new Interval(2, 2));
        intervals.add(new Interval(3, 3));
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(5, 7));
        intervals.add(new Interval(2, 2));
        intervals.add(new Interval(4, 6));
        List<Interval> result = merge(intervals);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i).start + "  ");
            System.out.println(result.get(i).end);
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() == 0) {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start > o2.start ? 1 : o1.start < o2.start ? -1 : 0;
            }
        });
     /*   for (int i = 0; i < intervals.size(); i++) {
            System.out.print(intervals.get(i).start+"  ");
            System.out.println(intervals.get(i).end);
        }*/
        List<Interval> result = new ArrayList<>();
        Interval interval = intervals.get(0);
        int preEnd = interval.end;
        for (int i = 1; i < intervals.size(); i++) {
            if (preEnd < intervals.get(i).start) {
                result.add(interval);
                interval = intervals.get(i);
                preEnd = interval.end;
            } else {
                if (preEnd < intervals.get(i).end) {
                    preEnd = intervals.get(i).end;
                    interval.end = preEnd;
                }
            }
        }
        result.add(interval);
        return result;
    }
}
