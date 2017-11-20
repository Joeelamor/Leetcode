// Problem 731 My Calendar II

// In this problem, we have two layers, first layer keep all intervals which 
//can be double booked. And second layer is to check if there is a triple booking.
class MyCalendarTwo {
    List<int[]> list;
    public MyCalendarTwo() {
        list = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        MyCalendar m = new MyCalendar();
        for (int[] l : list) {
            if (l[0] < start && l[1] > start) {
                if (!m.book(start, Math.min(end, l[1]))) {
                    return false;
                }
            } else if (l[0] >= start && l[0] < end) {
                if (!m.book(l[0], Math.min(end, l[1]))) {
                    return false;
                }
            }
        }
        list.add(new int[]{start, end});
        return true;
    }
    
    private class MyCalendar {
        TreeMap<Integer, Integer> calendar;
        public MyCalendar() {
            calendar = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            Integer floorKey = calendar.floorKey(start);
            if (floorKey != null && calendar.get(floorKey) > start) {
                return false;
            }
            Integer ceilingKey = calendar.ceilingKey(start);
            if (ceilingKey != null && ceilingKey < end) {
                return false;
            }
            calendar.put(start, end);
            return true;
        }
}


}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */

