/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function(nums, target) {
    var searchRange = [];
    for (var i = 0; i < nums.length; i++) {
        if (nums[i] === target) {
            searchRange.push(i);
        }
    }
    if(searchRange.length === 0) {
        searchRange = [-1, -1];
        return searchRange;
    }
    else if(searchRange.length === 1) {
        searchRange = [searchRange[0], searchRange[0]];
        return searchRange;
    }
    searchRange = [searchRange[0], searchRange[searchRange.length - 1]];
    return searchRange;
};