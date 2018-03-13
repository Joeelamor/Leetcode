// Problem 253 Meeting Room II

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (x, y) -> x.start - y.start);
        PriorityQueue<Interval> heap = new PriorityQueue<>(intervals.length, (x, y) -> x.end - y.end);
        heap.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval interval = heap.poll();
            if (intervals[i].start >= interval.end) {
                interval.end = intervals[i].end;
            } else {
                heap.offer(intervals[i]);
            }
            heap.offer(interval);
        }
        return heap.size();
    }
}

// Method 2

class Solution {
	public int minMeetingRooms(Interval[] intervals) {
		int[] starts = new int[intervals.length];
		int[] ends = new int[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			starts[i] = intervals[i].start;
			ends[i] = intervals[i].end;
		}
		Arrays.sort(starts);
		Arrays.sort(ends);
		int res = 0;
		int endIndex = 0;
	    for (int i = 0; i < starts.length; i++) {
	    	if (starts[i] < ends[endIndex]) {
	    		res++;
	    	} else {
	    		endIndex++;
	    	}
	    }
	    return res;
	}
}