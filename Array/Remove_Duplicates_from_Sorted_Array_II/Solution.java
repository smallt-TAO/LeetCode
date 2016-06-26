public class Solution {
    public int removeDuplicates(int[] nums) {
        int l = nums.length;
        if(l < 2) return l;
        
        int index = 2;
        for(int i = 2; i < l; i++){
            if(nums[index - 2] != nums[i])
            nums[index++] = nums[i];
        }
        return index;
        
    }
}