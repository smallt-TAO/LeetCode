/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {
    var result = [];

    (function dfs(left, right, partial) {
        if (left <= 0) {
            while (right > 0) {
                partial += ')';
                right--;
            }
            result.push(partial);
        } else {
            dfs(left - 1, right, partial + '(');
            
            if (right > left) {
               dfs(left, right - 1, partial + ')'); 
            }
        }
    })(n - 1, n, '(');
    
    return result;
};