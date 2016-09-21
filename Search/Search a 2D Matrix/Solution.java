// LeetCode, Search a 2D Matrix
// Time complexity O(n)
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int col = n - 1;
        
        while (row < m && col >= 0) {
            if (matrix[row][col] == target)
                return true;
            else if(matrix[row][col] < target)
                row++;
            else col--;
        }
        return false;
    }
}