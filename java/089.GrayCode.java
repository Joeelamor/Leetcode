// Problem 89 Gray Code

// Bit manipulation: 1<<n => 1 left move n bits. 1>>n => 1 right move n bits. >> have higher priority than ^.
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1<<n; i++) result.add(i ^ i>>1);
        return result;
    }
}