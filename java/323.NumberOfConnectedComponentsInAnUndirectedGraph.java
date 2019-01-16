// Question 323 Number of Connected Components in an Undirected Graph

class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
        for (int[] edge : edges) {
            int a = find(roots, edge[0]);
            int b = find(roots, edge[1]);
            if (a != b) {
                roots[a] = b;
                n -= 1;
            }
        }
        return n;
    }
    
    int find(int[] roots, int i) {
        if (roots[i] != i) {
            return find(roots, roots[i]);
        }
        return i;
    }
}