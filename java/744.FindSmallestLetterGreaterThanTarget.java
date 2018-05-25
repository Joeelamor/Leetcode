// Problem 744 Find Smallest Letter Greater Than Target

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length, i = 0, j = len - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (letters[mid] <= target) i = mid + 1;
            else j = mid - 1;
        }
        return i == len? letters[0] : letters[i];
    }
}