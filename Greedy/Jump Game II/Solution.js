/**
 * @param {number[]} nums
 * @return {number}
 */
var jump = function(nums) {
    if (nums.length <= 1) return 0;
    var lastEnd = 0;
    var minJump = 0;
    var nextEnd = nums[0];
    for (var i = 1; i < nums.length; i++) {
        if (i > lastEnd) {
            minJump++;
            lastEnd = nextEnd;
            nextEnd = 0;
        }
        if (nextEnd < nums[i] + i)  nextEnd = nums[i] + i;
    }
    return minJump;
};