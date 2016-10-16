// LeetCode, Combination Sum II
// Time complexity O(n!)
public class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        combSum_recursion(0, target, nums, list, res);
        return res;
    }
    
    void combSum_recursion(int index, int target, int[] nums, List<Integer> list, List<List<Integer>> res){
        if (target == 0) {
            res.add(new ArrayList<Integer>(list));
        } else if (target > 0){
            for (int i = index; i < nums.length; i++){
                list.add(nums[i]);
                combSum_recursion(i + 1, target - nums[i], nums, list, res);
                list.remove(list.size() - 1);
                while(i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
            }
        }// else target<0: do nothing, just return
    }
}