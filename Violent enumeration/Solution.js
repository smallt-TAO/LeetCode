/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function(nums) {
    var ret = [[]];
    var len = nums.length;
    if (len === 0) {
        return ret;
    }
    for (var i = 0; i < len; i++) {
        var l = ret.length;
        var num = nums[i];
        var array = [num];
        for (var j = 0; j < l; j++) {
            var tmparray = ret[j].concat(array);
            ret.push(tmparray);
            //console.log(ret);
        }
    }
    return ret;
};