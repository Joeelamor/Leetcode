// Problem 252 Meeting Rooms

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
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals.length <= 1)
            return true;
        // Sort the intervals by start time
        Arrays.sort(intervals, (x, y) -> x.start - y.start);
        for (int i = 1; i < intervals.length; i++)
            if (intervals[i-1].end > intervals[i].start)
                return false;
        return true;
    }
}

// override comparator function
class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals.length <= 1)
            return true;
        // Sort the intervals by start time
        Arrays.sort(intervals, new comparator<interval>() {
        	public int compare(interval a, interval b) {
        		return a.start - b.start;
        	}
        });
        for (int i = 1; i < intervals.length; i++)
            if (intervals[i-1].end > intervals[i].start)
                return false;
        return true;
    }
}