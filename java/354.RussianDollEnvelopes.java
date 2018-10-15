// Question 354 Russian Doll Envelopes

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 0; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

// Method 2: dp + binary search

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0])
                    return Integer.compare(b[1], a[1]);
                else
                    return Integer.compare(a[0], b[0]);
            }
        });
        int[][] dp = new int[envelopes.length][2];
        int size = 0;
        for (int[] envelope : envelopes) {
            int i = 0, j = size;
            while (i != j) {
                int mid = i + (j - i) / 2;
                if (dp[mid][0] < envelope[0] && dp[mid][1] < envelope[1])
                    i = mid + 1;
                else
                    j = mid;
            }
            dp[i] = envelope;
            if (i == size)
                size++;
        }
        return size;
    }
}