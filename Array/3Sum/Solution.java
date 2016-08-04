public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
    	
    	Arrays.sort(nums);
    	int start, end, temp;
    	for (int i = 0; i < nums.length; i++) {
    	    if (i != 0 && nums[i] == nums[i - 1]) continue;
    	        int current=nums[i];
    	        start = i + 1;
    	        end = nums.length - 1;

    	    while (start < end) {
    	        if (start != i + 1 && nums[start] == nums[start - 1]) { 
    	            start++;
    	            continue;
    	        }
    	        temp = nums[start]+nums[end];

    	        if (temp == -current) {                
    	        	List<Integer> list = new ArrayList<Integer>(3);
    	        	list.add(current);
    	        	list.add(nums[start]);
    	        	list.add(nums[end]);
    	        	result.add(list);
    	            start++;
    	            end--;
    	        }
    	        else if (temp > -current) end--;      
    	        else start++;                      
    	    }
    	}
    	return result;
    }
}
