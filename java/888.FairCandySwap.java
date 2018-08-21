// Question 888 Fair Candy Swap

class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0, sumB = 0, dif = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i : A) {
            sumA += i;
            set.add(i);
        }
        for (int i : B) 
            sumB += i;
        dif = (sumA - sumB) / 2;
        for (int i : B) {
            if (set.contains(i + dif)) {
                return new int[]{i + dif, i};
            }
        }
        return null;
    }
}