// Problem 593 Valid Square

// Checke whether it is a valid square, it has two equal diagonal lines and four equal sides.
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        HashSet<Integer> set = new HashSet<>();
        set.add(dis(p1, p2));
        set.add(dis(p1, p3));
        set.add(dis(p1, p4));
        set.add(dis(p2, p3));
        set.add(dis(p2, p4));
        set.add(dis(p3, p4));
        return !set.contains(0) && set.size() == 2;
    }
    private int dis(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
}