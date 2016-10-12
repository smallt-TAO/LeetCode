/**
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function(n) {
    var map = [];
    var result = [];   
    buildMap();
    dfs(0);
    return result;

    function dfs(row){
        var i = 0, j = 0;
        var candidates = [];
        for(i = 0; i < n; i++){
            if(canPlaceQueen(row, i)){
                candidates.push(i);
            }
        }
        if(row === n -1 && candidates.length !== 0){ //found
            map[row][candidates[0]] = 'Q';
            result.push(formatMap(map));
            map[row][candidates[0]] = '.';
            return;
        }
        for(i = 0; i < candidates.length; i++){
            map[row][candidates[i]] = 'Q';
            dfs(row + 1);
            map[row][candidates[i]] = '.';
        }
    }
    function canPlaceQueen(x, y){
        var cell = "";
        var i = 0, j = 0;
        for(i = 0; i < n; i++){
            cell = map[i][y];
            if(cell === 'Q'){
                return false;
            } 
        }
        for(i = x, j = y; i >=0 && j >= 0; i--, j--){
            cell = map[i][j];
            if(cell === 'Q'){
                return false;
            } 
        }
        for(i = x, j = y; i >=0 && j < n; i--, j++){
            cell = map[i][j];
            if(cell === 'Q'){
                return false;
            } 
        }
        return true;
    }
    function buildMap(){
        var i = 0, j = 0;
        for(i = 0; i < n; i++){
            map[i] = [];
        }
        for(i = 0; i < n; i++){
            for(j = 0; j < n; j++){
                map[i][j] = '.';
            }
        }
    }
    function formatMap(map){
        var res = [];
        var i = 0, j = 0;
        for(i = 0; i < n; i++){
            var tmp = "";
            for(j = 0; j < n; j++){
                tmp += map[i][j];
            }
            res.push(tmp);
        }
        return res;
    }
};