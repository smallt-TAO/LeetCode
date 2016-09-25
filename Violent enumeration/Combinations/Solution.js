/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine = function(n, k) {
    var curr = [];
    var result = []
    function helper(n, k, start, curr, result) {
        if (k === 0) {
            result.push(curr.slice());
            return;
        }
        for (var i = start; i <= n; i++) {
            curr.push(i);
            helper(n, k-1, i+1, curr, result);
            curr.pop();
        }
    }
    helper(n, k, 1, curr, result);
    return result;
};