// LeetCode, Subsets
// Time complexity O(2^n)
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int all = 1 << nums.length;
		Arrays.sort(nums);
		List<List<Integer>> subsetsList = new ArrayList();
		for (int i = 0; i < all; i++) {
			int b = 1;
			List<Integer> tmpList = new ArrayList();
			for (int j = 0; j < nums.length; j++) {
				if ((i & b) != 0) {
					tmpList.add(nums[j]);
				}
				b <<= 1;
			}
			subsetsList.add(tmpList);
		}
		return subsetsList;
    }
}