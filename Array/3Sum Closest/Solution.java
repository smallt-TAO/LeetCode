public class Solution {
    public int threeSumClosest(int[] nums, int target) {
    	Arrays.sort(nums);
    	int firstSum = nums[0] + nums[1] + nums[2];
    	int start, end;
    	for (int i = 0; i < nums.length - 2; i++) {
    	    if (i != 0 && nums[i] == nums[i - 1]) continue;
    	        int current = nums[i];
    	        start = i + 1;
    	        end = nums.length - 1;

    	    while (start < end) {
    	        if (start != i + 1 && nums[start] == nums[start - 1]) { 
    	            start++;
    	            continue;
    	        }
    	        int curSum = nums[i] + nums[start] + nums[end];
    	        if (curSum == target) return curSum;
    	        if (Math.abs(curSum - target) < Math.abs(firstSum - target)) firstSum = curSum; 
    	        if (curSum > target) {
    	            end--;
                } else {
                    start++;
                }                  
    	    }
    	}
    	return firstSum;
    }
}
