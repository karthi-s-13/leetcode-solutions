class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        for(int[] interval : intervals){
            int[] last = result.isEmpty() ? null : result.get(result.size() - 1);
            if(last != null && interval[0] <= last[1]){
                last[1] = Math.max(interval[1], last[1]);
            }
            else{
                result.add(interval);
            }
        }
        return result.toArray(new int[0][]);
    }
}