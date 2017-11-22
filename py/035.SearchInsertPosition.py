# Problem 35 Search Insert Position

class Solution:
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        start = 0
        for start in range(len(nums)):
            if nums[start] >= target:
                return start
        return len(nums)
                
        