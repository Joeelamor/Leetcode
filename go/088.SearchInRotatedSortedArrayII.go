// Question 88 Search in Rotated Sorted Array II

func search(nums []int, target int) bool {
    if len(nums) == 0 {
        return false
    }
    left := 0
    right := len(nums) - 1
    for left < right {
        mid := left + (right - left) / 2
        if target == nums[mid] {
            return true;
        } 
        if nums[left] == nums[mid] && nums[right] == nums[mid] {
            left++
            right--
        } else if target < nums[mid] {
            if nums[left] <= nums[mid] && nums[left] > target {
                left = mid + 1
            } else {
                right = mid - 1
            }
        } else { 
            if nums[mid] <= nums[right] && nums[right] < target { 
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
    }
    if target == nums[left] {
        return true
    } else {
        return false
    }
}