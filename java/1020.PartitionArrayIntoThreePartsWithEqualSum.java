// Question 1020 Partition Array Into Three Parts With Equal Sum

class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i : A)
            sum += i;
        if (sum % 3 != 0)
            return false;
        sum /= 3;
        System.out.println(sum);
        int left = 0, right = 0;
        for (int i = 0, j = A.length - 1; i <= j;) {
            if (left == sum && right == sum)
                return true;
            if (left != sum) {
                left += A[i];
                i++;
            }
            if (right != sum) {
                right += A[j];
                j--;
            }
        }
        return false;
    }
}