// Problem 875 Koko Eating Bananas

class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int min = 1, max = Integer.MIN_VALUE;
        for (int i : piles) {
            max = Math.max(max, i);
        }
        while (min < max) {
            int mid = min + (max - min) / 2;
            int count = 0;
            for (int i : piles) {
                count += Math.ceil((double)i / mid);   
            }
            if (count <= H)
                max = mid;
            else 
                min = mid + 1;
        }
        return min;
    }
}