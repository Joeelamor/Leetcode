// Problem 261 Graph Valid Tree

class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] nums = new int[n]; // initialize n isolated nodes.
        Arrays.fill(nums, -1);
        for (int i = 0; i < edges.length; i++) {
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);
            
            if (x == y) return false; // if two vertices are in a same set, there is a cycle.
            nums[x] = y; // union
        }
        return edges.length == n - 1;
    }
    private int find(int[] num, int i) {
        if (num[i] == -1) return i;
        return find(num, num[i]);
    }
}