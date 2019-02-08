// 974 Subarray Sums Divisible by K

class Solution {
    public int subarraysDivByK(int[] A, int K) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            sum = K == 0 ? sum : sum % K;
            if(sum < 0) sum += K;
            if (map.containsKey(sum))
                res += map.get(sum);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
