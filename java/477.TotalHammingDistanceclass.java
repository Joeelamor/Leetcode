// Problem 477 Total Hamming Distanceclass 
Solution {
    public int totalHammingDistance(int[] nums) {
        int total = 0, len = nums.length;
        for (int i = 0; i < 32; i++) {
            int bitCount = 0;
            for (int j = 0; j < len; j++) {
                // for all numbers in array, count the number of 1.
                bitCount += (nums[j] >> i) & 1;
            }
            // there are only 1 or 0 in a bit, bitCount is the numebr of 1.
            // for one bit of all numbers, bitCount * (len - bitCount) is hamming distance. 
            total += bitCount * (len - bitCount);
        }
        return total;
    }
}