//LeetCode
//Time complexity O(n),Space complexity 
class Solution {
public:
    bool search(vector<int>& nums, int target) {
        int left = 0,  l = nums.size(), right = l - 1, mid;
        
        if(l == 0) return false;
        
        while(left <= right)
        {
            mid = (left + right) / 2;
            if(target == nums[mid]) return true;
            if(nums[mid] == nums[left]) left++;
            else if(nums[left] < nums[mid]){
                if (nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } 
            else{
                if (nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return false;
    }
};