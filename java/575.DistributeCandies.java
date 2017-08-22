// Problem 575 Distribute Candies

class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> map = new HashSet<>();
        for(int num: candies)
            map.add(num);
        return map.size() >= candies.length / 2? candies.length / 2: map.size();
    }
}