class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));
        int remove = 0;
        long end = Integer.MIN_VALUE;
        for(int[] iv : intervals){
            if(iv[0] >= end) end = iv[1];
            else remove++; 
        }
        return remove;
    }
}