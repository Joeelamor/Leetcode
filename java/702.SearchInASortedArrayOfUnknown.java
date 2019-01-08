//Question 702 Search In A Sorted Array Of Unknown Size

class Solution {
    public int search(ArrayReader reader, int target) {
        int hi = 1;
        while (reader.get(hi) < target) {
            hi <<= 1;
        }
        int lo = hi >> 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (reader.get(mid) == target)
                return mid;
            else if (reader.get(mid) < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return -1;
    }
}