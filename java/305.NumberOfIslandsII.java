// Question 305 Number of Islands II

class Solution {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (m <= 0 || n <= 0) 
            return res;
        int count = 0;
        int[] roots = new int[m * n];
        Arrays.fill(roots, -1);
        for (int[] pos : positions) {
            int root = pos[0] * n + pos[1];
            roots[root] = root;
            count++;
            for (int i = 0; i < 4; i++) {
                int x = pos[0] + dirs[i][0];
                int y = pos[1] + dirs[i][1];
                int cur = x * n + y;
                if (x < 0 || y < 0 || x >= m || y >= n || roots[cur] == -1)
                    continue;
                int rootCur = findRoot(roots, cur);
                if (root != rootCur) {
                    roots[root] = rootCur;  
                    root = rootCur;          
                    count--; 
                }
            }
            res.add(count);
         }
        return res;
    }
    
    // private int findRoot(int[] roots, int cur) {
    //     while (roots[cur] != cur) {
    //         cur = roots[cur];
    //         roots[cur] = roots[roots[cur]]; // shorten tree to speed up
    //     }
    //     return cur;
    // }

    private int findRoot(int[] roots, int cur) {
        while (roots[cur] != cur)
            cur = roots[cur];
        return cur;
    }
    
}