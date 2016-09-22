/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsetsWithDup = function(nums) {
    var result = [];
    var list = [];
    nums.sort(function(a, b) {return a - b;});
    subsetsHelper(result, list, nums, 0);
    return result;

    function subsetsHelper(result, list, nums, pos) {
        result.push(list.slice()); // important! add a duplicate of list
        for(var i = pos; i < nums.length; i++){
            if(i !== pos && nums[i] === nums[i - 1]){
                continue;
            }
            var length = list.length;
            list.push(nums[i]);
            subsetsHelper(result, list, nums, i + 1);
            list.length = length; // remove the added list
        }
    }
};