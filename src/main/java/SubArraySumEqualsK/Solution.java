package SubArraySumEqualsK;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] prefixSum = new int[nums.length+1];

        prefixSum[0] = 0;
        for(int i=1; i< nums.length; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i-1];
        }

        int i=0, j=0, count=0;
        while(i<=nums.length){
            if(i<nums.length && nums[i] == k)
                count++;

            while(j<i && prefixSum[i]-prefixSum[j]>=k){
                if(prefixSum[i]-prefixSum[j] == k)
                    count++;
                j++;
            }
            i++;
        }
        return count;
    }
}
