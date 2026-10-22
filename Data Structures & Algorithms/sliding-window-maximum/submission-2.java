class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0, right = k - 1, size = nums.length, index = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int result[] = new int[nums.length - k + 1];

        for (int i = 0; i < k; ++i) {
            queue.add(nums[i]);
        }

        result[index++] = queue.peek();

        while (right + 1 < size) {
            queue.remove(nums[left++]);
            queue.add(nums[++right]);

            result[index++] = queue.peek();
        }

        return result;
    }
}
