# 670. Maximum Swap

### Difficulty: Medium

## Description
You are given an integer num. You can swap two digits at most once to get the maximum valued number.

Return the maximum valued number you can get.

 
Example 1:


Input: num = 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.


Example 2:


Input: num = 9973
Output: 9973
Explanation: No swap.


 
Constraints:


	0 <= num <= 108

## Submission Details
- **Status**: Accepted
- **Runtime**: 0 ms
- **Memory**: 41636000
- **Language**: java

## Code
```java
class Solution {
    public int maximumSwap(int num) {
        String str = String.valueOf(num);
        char[] arr = str.toCharArray();
        
        for(int i=0;i<arr.length -1;i++){
            int index = -1;
            int maxValue = Integer.MIN_VALUE;
            for(int j=i+1;j<arr.length;j++){
                if(maxValue <= arr[j]){
                    maxValue = arr[j];
                    index = j;
                }
            }
            if(arr[i] < arr[index]){
                char temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                break;
            }            
        }

        str = String.valueOf(arr);
        return Integer.parseInt(str);
    }
}
```
