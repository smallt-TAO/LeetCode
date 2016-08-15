public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] used1 = new int[9][9];
        int[][] used2 = new int[9][9];
        int[][] used3 = new int[9][9];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                used1[i][j] = 0;
                used2[i][j] = 0;
                used3[i][j] = 0;
            }
        
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0' - 1;
                    int k = i / 3 * 3 + j / 3;
                    if ((used1[i][num] + used2[j][num] + used3[k][num]) != 0)
                        return false;
                    used1[i][num] = used2[j][num] = used3[k][num] = 1;
                }   
        return true;
    }
}