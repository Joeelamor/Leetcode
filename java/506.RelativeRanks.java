// Problem 506 Relative Ranks

class Solution {
    public String[] findRelativeRanks(int[] nums) {
        // Array.sort(T[] a, Comparator<? super T> c), so we use Integer[], int is primary type not generic type(T).
        Integer[] index = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> (nums[b] - nums[a]));
        String[] res = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) res[index[i]] = "Gold Medal";
            else if (i == 1) res[index[i]] = "Silver Medal";
            else if (i == 2) res[index[i]] = "Bronze Medal";
            else res[index[i]] = (i + 1) + "";
        }
        return res;
    }
}