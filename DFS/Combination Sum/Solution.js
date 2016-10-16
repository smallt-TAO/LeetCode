/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum = function(candidates, target) {
    var res = [];
    candidates.sort(sorting);
    dfs(0, 0, []);
    return res;
    
    function dfs(sum, index, tmp) {
        if (sum === target) {
            newTmp = tmp.concat();
            res.push(newTmp);
            return;
        } else if (sum > target) {
            return;  // pruning
        }
        for (var i = index; i < candidates.length; i++) {
            newTmp = tmp.concat();
            newTmp.push(candidates[i]);
            dfs(sum + candidates[i], i, newTmp);
        }
    }
    
    function sorting(a, b) {
        if (a > b) {
            return 1;
        } else if (a < b) {
            return -1;
        } else {
            return 0;
        }
    }
};