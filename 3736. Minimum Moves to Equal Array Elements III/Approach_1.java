class Solution {
    public int minMoves(int[] nums) {
        int maxNum = Integer.MIN_VALUE;
        for(int num : nums){
            if(maxNum < num) maxNum = num;
        }
        int minStep = 0;
        for(int num : nums){
            minStep += (maxNum - num);
        }
        return minStep;
    }
}