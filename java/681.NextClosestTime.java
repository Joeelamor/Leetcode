// Problem 681 Next Closest Time

class Solution {
    public String nextClosestTime(String time) {
        int t1 = time.charAt(0) - '0';
        int t2 = time.charAt(1) - '0';
        int t3 = time.charAt(3) - '0';
        int t4 = time.charAt(4) - '0';
        int hour = t1 * 10 + t2, minute = t3 * 10 + t4;
        // Use boolean array to check if the number is in t1 - t4.
        boolean []a = new boolean[10];
        a[t1] = a[t2] = a[t3] = a[t4] = true;
        
        // Every time add one minute to check if it satisfies.
        for (int m = (minute + 1) % 60, h = (hour + (m == 0 ? 1 : 0)) % 24; h != hour || m != minute; m = (m + 1) % 60, h = (h + (m == 0 ? 1 : 0)) % 24)
            if (a[h / 10] && a[h % 10] && a[m / 10] && a[m % 10]) {
                return "" + (h < 10 ? ("0" + h) : h) + ":" + (m < 10 ? ("0" + m) : m);
            } 
        return time;
    }
}