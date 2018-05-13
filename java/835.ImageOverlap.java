// Problem 835 Image Overlap

class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int n = A.length;
        LinkedList<Integer> LA = new LinkedList<>();
        LinkedList<Integer> LB = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        // Use list to store coordinations which represent 1.
        for (int i = 0; i < n * n; i++) if (A[i / n][i % n] == 1) LA.add(i / n * 100 + i % n);
        for (int i = 0; i < n * n; i++) if (B[i / n][i % n] == 1) LB.add(i / n * 100 + i % n);
        // if there are some differences are same which proves that they are overlapped, then count them.
        for (int a : LA) {
            for (int b : LB) {
                map.put(a - b, map.getOrDefault(a - b, 0) + 1);
            }
        }
        int res = 0;
        for (int i : map.values()) res = Math.max(res, i);
        return res;
    }
}