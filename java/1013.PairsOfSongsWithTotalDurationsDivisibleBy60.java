// Question 1013 Pairs of Songs With Total Durations Divisible by 60

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] count = new int[60];
        int res = 0;
        for (int i : time) {
        	// Like using a hashmap
            res += count[(60 - (i % 60)) % 60];
            count[i % 60]++;
        }
        return res;
    }
}