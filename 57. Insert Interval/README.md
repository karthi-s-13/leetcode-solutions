# 57. Insert Interval

### Difficulty: Medium

## Description
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Two intervals are considered overlapping if they share at least one point.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Note that you don't need to modify intervals in-place. You can make a new array and return it.

 
Example 1:


Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]


Example 2:


Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].


 
Constraints:


	0 <= intervals.length <= 104
	intervals[i].length == 2
	0 <= starti <= endi <= 105
	intervals is sorted by starti in ascending order.
	newInterval.length == 2
	0 <= start <= end <= 105

## Submission Details
- **Status**: Accepted
- **Runtime**: 1
- **Memory**: 46592000
- **Language**: java

## Code
```java
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
```
