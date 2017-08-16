// Problem 447 Number of Boomerangs

public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < points.length; i++) {
            for(int j = 0; j < points.length; j++) {
                if(i == j)
                    continue;
                int d = getDistance(points[i], points[j]);
                hashMap.put(d, hashMap.getOrDefault(d, 0) + 1);
            }
            
            for(int val : hashMap.values())
                res += val * (val - 1);
            
            hashMap.clear();
        }
        return res;
    }
    
    public int getDistance(int[] a, int[] b) {
        int x = a[0] - b[0], y = a[1] - b[1];
        return x*x + y*y;
    }
}