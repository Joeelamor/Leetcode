// Question 547 Friend Circles

// method 1 : Union-find
class Solution {
    public int findCircleNum(int[][] M) {
        int[] parent = new int[M.length];
        Arrays.fill(parent, -1);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && i != j) {
                    int a = find(parent, i);
                    int b = find(parent, j);
                    if (a != b)
                        parent[a] = b;
                }
            }
        }
        int count = 0;
        for (int i : parent)
            if (i == -1)
                count++;
        return count;
    }
    
    int find(int[] parent, int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }
}