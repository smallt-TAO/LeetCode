// LeetCode, Combination Sum
// Time complexity O(n!)
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        
        Arrays.sort(candidates);
        dfs(candidates, 0, target, list, res);
        return res;
    }
    
    public static void dfs(int candidates[], int k, int target, List<Integer> list,List<List<Integer>> res) {
		if (target < 0 || k >= candidates.length) return;
        if (0 == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(candidates[k]);
        dfs(candidates, k, target - candidates[k], list, res);
        list.remove(list.size() - 1);
        while (k + 1 < candidates.length && candidates[k] == candidates[k + 1]) {
            k++;
        }
        dfs(candidates, k + 1, target, list, res);
    }
}