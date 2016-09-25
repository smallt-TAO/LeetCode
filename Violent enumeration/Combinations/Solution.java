// LeetCode, Combinations
// Time complexity O(n)
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> solution = new ArrayList<Integer>();
        
        helper(ret, solution, n, k, 1);
        return ret;
    }
    
    private void helper(List<List<Integer>> rst, List<Integer> solution, int n, int k, int start) {
        if (solution.size() == k) {
            rst.add(new ArrayList(solution));
            return;
        }
        
        for (int i = start; i <= n; i++) {
            solution.add(i);
            helper(rst, solution, n, k, i + 1);
            solution.remove(solution.size() - 1);
        }
    }
}