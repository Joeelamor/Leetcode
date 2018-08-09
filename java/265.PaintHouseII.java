// Question 265 Paint House II

class Solution {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int min1 = 0, min2 = 0, index = -1;
        for (int i = 0; i < costs.length; i++) {
            int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE, idx = -1;
            for (int j = 0; j < costs[0].length; j++) {
                int cost = costs[i][j] + (j != index ? min1 : min2);
                if (cost < m1) {
                    m2 = m1;
                    m1 = cost;
                    idx = j;
                } else if (cost < m2) {
                    m2 = cost;
                }
            }
            min1 = m1;
            min2 = m2;
            index = idx;
        }
        return min1;
    }
}