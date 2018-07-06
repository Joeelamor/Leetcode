// Problem 825 Friends Of Appropriate Ages

// O(n) time, O(1) space
class Solution {
    public int numFriendRequests(int[] ages) {
        int res = 0;
        int[] numInAge = new int[121], sumInAge = new int[121];
        
        for(int i : ages) 
            numInAge[i]++;
        
        for(int i = 1; i <= 120; ++i) 
            sumInAge[i] = numInAge[i] + sumInAge[i - 1];
        
        for(int i = 15; i <= 120; ++i) {
            if(numInAge[i] == 0) continue;
            int count = sumInAge[i] - sumInAge[i / 2 + 7];
            //people will not friend request themselves, so  - numInAge[i]
            res += count * numInAge[i] - numInAge[i]; 
        }
        return res;
    }
}

// O(n^2)
class Solution {
    public int numFriendRequests(int[] ages) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int age : ages) map.put(age, map.getOrDefault(age, 0) + 1);
        int res = 0;
        for (Integer a : map.keySet()) 
            for (Integer b : map.keySet())
                if (request(a, b)) 
                    res += map.get(a) * (map.get(b) - (a == b ? 1 : 0));
        return res;
    }

    private boolean request(int a, int b) {
        return !(b <= 0.5 * a + 7 || b > a || (b > 100 && a < 100));
    }

}