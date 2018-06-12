// Problem 849 Maximize Distance To Closest Person

class Solution {
    public int maxDistToClosest(int[] seats) {
        int max = 0, i = 0;
        for (int j = 0; j < seats.length; j++) {
            if (seats[j] == 1) {
                if (i == 0) max = Math.max(max, j - i);
                else max = Math.max(max, (j - i + 1) / 2);
                i = j + 1;
            }
        }
        max = Math.max(max, seats.length - i);
        return max;
     }
}