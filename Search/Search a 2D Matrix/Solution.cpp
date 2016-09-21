// LeetCode, Search a 2D Matrix
// Time complexity O(n)
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int row = 0;
        int m = matrix.size();
        int n = matrix.front().size();
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
};