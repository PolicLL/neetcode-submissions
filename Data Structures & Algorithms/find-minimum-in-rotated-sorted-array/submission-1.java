class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;

        int min = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = (start + end) / 2;
            int midVal = nums[mid];
            if (midVal < min)
                min = midVal;
            if (midVal > nums[end]) {
                start = mid + 1;
            }
            else end = mid - 1;
        }

        return min;
    }
}
