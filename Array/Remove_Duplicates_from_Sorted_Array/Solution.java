public int removeDuplicates(int[] nums) {
    int cur = 0 ; 
    for(int n:nums)
        if(n > nums[cur])
            nums[++cur] = n;
    return cur + 1;
}