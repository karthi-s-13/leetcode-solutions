class Solution {
    public int minMoves(int[] nums) {
        int maxValue = Integer.MIN_VALUE;
        int sum = 0;
        for(int num : nums){
            sum += num;
            if(maxValue < num) maxValue = num;
        }
        return nums.length * maxValue - sum;
        
    }
}