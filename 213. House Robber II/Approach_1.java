class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        return Math.max(robit(nums, 0, n-1),robit(nums, 1, n));
    }
    public static int robit(int[] nums, int start, int end){
        int[] dp = new int[end];
        dp[start] = nums[start];
        dp[start+1] = Math.max(nums[start], nums[start+1]);
        for(int i=start + 2;i<end;i++){
            int skip = dp[i-1];
            int take = dp[i-2] + nums[i];
            dp[i] = Math.max(skip, take);
        }
        return dp[end-1];
    }
}