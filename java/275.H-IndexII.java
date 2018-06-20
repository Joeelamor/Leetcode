// Problem 275 H-Index II

class Solution {
    public int hIndex(int[] citations) {
        int left = 0, right = citations.length - 1, len = citations.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] == len - mid) return len - mid;
            else if (citations[mid] > len - mid) right = mid - 1;
            else left = mid + 1;
        }
        return len - left;
    }
}