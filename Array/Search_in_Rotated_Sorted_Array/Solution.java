public class Solution {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }
    public int search (int[] nums, int first, int last, int target) {
        if (first > last) return -1;
        
        int mid = (first + last) / 2;
        if (nums[mid] == target) return mid;

        if (nums[first] <= nums[mid]) // Left side is sorted
            if (target <= nums[mid] && target >= nums[first]) // target is on left side
                return search (nums, first, mid - 1, target);
            else // target is on the right side
                return search (nums, mid + 1, last, target);
        if (nums[mid] <= nums[last])// Right side is sorted
            if (target >= nums[mid] && target <= nums[last]) // target is right side
                return search (nums, mid + 1, last, target);
            else // target is on left side
                return search (nums, first, mid - 1, target);

        return -1;
    }
}