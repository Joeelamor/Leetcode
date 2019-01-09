// Question 528 Random Pick with Weight

class Solution {
    Random rand;
    int[] sum;
    public Solution(int[] w) {
        rand = new Random();
        for (int i = 1; i < w.length; i++) {
            w[i] = w[i] + w[i - 1];
        }
        this.sum = w;
    }
    
    public int pickIndex() {
        int idx = rand.nextInt(sum[sum.length - 1]) + 1;
        int left = 0, right = sum.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sum[mid] == idx) 
                return mid;
            else if (sum[mid] < idx) 
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */