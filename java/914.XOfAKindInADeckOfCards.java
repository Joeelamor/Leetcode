// Question 914 X of a Kind in a Deck of Cards

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : deck) { 
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int res = 0;
        for (int value : map.values()) {
            res = gcd(value, res);
        }
        return res > 1;
    }
    
    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return a == 0 ? b : gcd(b, a % b);
    }
}
