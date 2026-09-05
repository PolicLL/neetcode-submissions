class Solution {
    public int maxArea(int[] heights) {
        int start = 0, end = heights.length - 1;
        int maxArea = 0;

        while (start < end) {
            int startH = heights[start];
            int endH = heights[end];
            int tempArea = (end - start) * Math.min(startH, endH);

            if (tempArea > maxArea) {
                maxArea = tempArea;
            }

            if (startH > endH) end--;
            else start++;
        }

        return maxArea;
    }
}
