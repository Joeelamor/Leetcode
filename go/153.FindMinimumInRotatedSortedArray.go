// Question 153 Find Minimum in Rotated Sorted Array

func findMin(nums []int) int {
    var (
        left = 0
        right = len(nums) - 1
    )
    for left < right {
        mid := left + (right - left) / 2
        if nums[mid] < nums[right] {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return nums[left]
}