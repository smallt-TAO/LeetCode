// LeetCode, Word Search
// Time complexity O(n^2)
public class Solution {
    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0) return true;
        char c = word.charAt(0);
        boolean res = false;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == c) {
                    board[i][j] = '.';
                    res = search(board, word, i, j, 1);
                    board[i][j] = c;
                    if(res) return res;
                }
            }
        }
        return res;
    }
    
    public boolean search(char[][] board, String world, int low, int raw, int index) {
        if(index == world.length()) return true;
        boolean res = false;
        char c = world.charAt(index);
        if(low > 0 && board[low - 1][raw] == c) {
            board[low - 1][raw] = '.';
            res = search(board, world, low - 1, raw, index + 1);
            if(res) return res;
            board[low - 1][raw] = c;
        }
        if(low < board.length - 1 && board[low + 1][raw] == c) {
            board[low + 1][raw] = '.';
            res = search(board, world, low + 1, raw, index + 1);
            if(res) return res;
            board[low + 1][raw] = c;
        }
        if(raw > 0 && board[low][raw - 1] == c) {
            board[low][raw - 1] = '.';
            res = search(board, world, low, raw - 1, index + 1);
            if(res) return res;
            board[low][raw - 1] = c;
        }
        if(raw < board[0].length - 1 && board[low][raw + 1] == c) {
            board[low][raw + 1] = '.';
            res = search(board, world, low, raw + 1, index + 1);
            if(res) return res;
            board[low][raw + 1] = c;
        }
        return res;
    }
}