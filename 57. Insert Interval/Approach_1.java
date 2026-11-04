class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int i=0;
        int s = newInterval[0];
        int e = newInterval[1];
        List<int[]> result = new ArrayList<>();
        //Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        while(i < n && intervals[i][1] < s){
            result.add(intervals[i++]);
        }
        while(i < n && intervals[i][0] <= e){
            s = Math.min(s, intervals[i][0]);
            e = Math.max(e, intervals[i][1]);
            i++;
        }
        result.add(new int[]{s,e});
        while(i < n ) result.add(intervals[i++]);
        return result.toArray(new int[0][]);
    }
}