/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var searchInsert = function(nums, target) {
    if (nums.length === 0) {
        return 0;
    }

    var start = 0;
    var end = nums.length - 1;
    var mid = 0;
    while (start + 1 < end) {
        mid = ~~((start + end) / 2);
        if (nums[mid] >= target) {
            end = mid;
        } else {
            start = mid;
        }
    }
    
    if (nums[start] >= target) {
        return start;
    }
    if (nums[end] >= target) {
        return end;
    }
    
    return nums.length;
};