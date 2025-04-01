package SubArraySumEqualsK;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] input = new int[]{1,2,2,3,1,1,4};

        System.out.println("SubArray counts are :: "+ solution.subarraySum(input, 5));
    }
}
