class Solution {
    public int findDuplicate(int[] nums) {
        int first = 0, second = 0;

        while (true) {
            first = nums[first];
            second = nums[nums[second]];
            if (first == second) break;
        }

        second = 0;

        while (first != second) {
            first = nums[first];
            second = nums[second];
        }

        return first;
    }

    // 0 1 3 2 4 2 4 2
}
