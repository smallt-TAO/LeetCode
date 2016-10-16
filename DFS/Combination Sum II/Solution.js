/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum2 = function(candidates, target) {
    var res = [];
    var visited = new Set();
    candidates.sort(sorting);
    bfs(0, -1, []);
    return res;
    
    function bfs(sum, index, tmp) {
        var current = tmp.join('#');
        if (visited.has(current)) {
            return;
        } else {
            visited.add(current);
        }
        
        var newTmp = null;
        if (sum === target) {
            newTmp = tmp.concat();
            res.push(newTmp);
            return;
        } else if (sum > target || index + 1 >= candidates.length) {
            return;  // pruning
        }
        
        for (var i = index + 1; i < candidates.length; i++) {
            newTmp = tmp.concat();
            newTmp.push(candidates[i]);
            bfs(sum + candidates[i], i , newTmp);
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