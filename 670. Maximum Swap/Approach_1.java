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