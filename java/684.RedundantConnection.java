// Problem 684 Redundant Connection

/* We use union find to solve this problem, we we find two points having the same parent, 
 * then return this edge.
 */
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int []parent = new int[2000];
        for (int i = 0; i < 2000; i++) {
            parent[i] = i;
        }
        int index = -1;
        for (int i = 0; i < edges.length; i++) {
            int a = findParent(parent, edges[i][0]);
            int b = findParent(parent, edges[i][1]);
            // If two points' parents are same, then return the edge.
            if (a == b) {
                index = i;
            // If two points' parents are different, set the smaller value as parent.
            } else {
                if (a > b) {
                    parent[a] = b;
                } else {
                    parent[b] = a;
                }
            }
        }
        return edges[index];
    }
    // This function is used to find parent of a point, and return its parent.
    public int findParent(int []parent, int node) {
        while (parent[node] != node) {
            node = parent[node];
        }
        return node;
    }
}