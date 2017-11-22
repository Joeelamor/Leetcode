// Problem 276 Paint Fence

// Use DP
class Solution {
    public int numWays(int n, int k) {
        if (n == 0)
            return 0;
        if (n == 1)
            return k;
        int[] same = new int[n];
        int[] diff = new int[n];
        same[0] = same[1] = k;
        diff[0] = k;
        diff[1] = k * (k - 1);
        for (int i = 2; i < n; i++) {
        	// if same[i], which means diff[i - 1], so same[i] = diff[i - 1].
            same[i] = diff[i - 1];
            // if diff[i], which means same[i - 1] or diff[i - 1], so diff[i] = same[i - 1] * (k - 1) + diff[i - 1] * (k - 1).
            diff[i] = same[i - 1] * (k - 1) + diff[i - 1] * (k - 1);
        }
        return same[n - 1] + diff[n - 1];
    }
}

// Method 2: O(n) time, O(1) space
class Solution {
    public int numWays(int n, int k) {
        if (n == 0)
            return 0;
        if (n == 1)
            return k;
        int same = k;
        int diff = k * (k - 1);
        for (int i = 2; i < n; i++) {
            int tmp = diff;
            diff = same * (k - 1) + diff * (k - 1);
            same = tmp;
        }
        return same + diff;
    }
}