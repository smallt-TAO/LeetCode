/**
 * @param {number[]} nums
 * @return {number}
 */
var firstMissingPositive = function(nums) {
    if (nums === null) {
        return 1;
    }
    
    for (var i = 0; i < nums.length; i++) {
        while (nums[i] > 0 && nums[i] <= nums.length && nums[i] !== (i + 1)) {
            var tmp = nums[nums[i] - 1];
            if (tmp === nums[i]) {
                break;
            }
            nums[nums[i] - 1] = nums[i];
            nums[i] = tmp;
        }
    }
    
    for (var j = 0; j < nums.length; j++) {
        if (nums[j] !== j + 1) {
            return j + 1;
        }
    }
    
    return nums.length + 1;
};