package SubArrayProblems;

public class RemoveShortestSubarray {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;

        if(n == 0)
            return 0;

        int i=0, j=n-1;

        while(i< n-1 && arr[i] <= arr[i+1]){
            i++;
        }

        while(j > 0 && arr[j] > arr[j-1]){
            j--;
        }

        int k=i;
        i=0;

        int smallestSubLength = Integer.MAX_VALUE;
        while(i<= k){
            if(arr[i] <= arr[j]){
                smallestSubLength = Math.min(smallestSubLength, j-i-1);
                i++;
            }
            else{
                j++;
            }
        }

        smallestSubLength = Math.min(smallestSubLength, j-i-1);

        return smallestSubLength;
    }
}
