public class Solution {
    public void nextPermutation(int[] nums) {
        int i;
        int j;
        int len = nums.length;
        for (i = len - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                for (j = len - 1; j >= i; j--) {
                    if (nums[j] > nums[i]) break;
                }
                swap(nums, i, j);
                i++; 
                j = len - 1;
                while(i < j) swap(nums, i++, j--);
                return;
            }
        }
        i = 0; 
        j = len - 1;
        while(i < j) swap(nums, i++, j--);
    }
    
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}