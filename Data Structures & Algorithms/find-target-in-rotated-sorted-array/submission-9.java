class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            System.out.println("start " + start + " end " + end);
            int mid = (start + end) / 2;
            int midVal = nums[mid];

            if (midVal == target) return mid;

            if (isBetween(nums[start], midVal, target)) {
                end = mid - 1;
            }
            else
                start = mid + 1;
            
        }

        return -1;
    }

    private boolean isBetween(int l, int r, int target) {
        if (l > r) {
            return target <= r || target >= l;
        }

        return target >= l && target <= r;
    } 
}
