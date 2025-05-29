package ContainerWithMostWater;

public class Solution {
    public int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;

        int left = 0, right = height.length - 1;

        while(left < right) {
            int width = right - left;

            maxArea = Math.max(maxArea,
                            width * Math.min(height[left], height[right]));

            if(height[left] < height[right]) {
                left++;
            }
            else {
                right--;
            }
        }

        return maxArea;
    }
}
