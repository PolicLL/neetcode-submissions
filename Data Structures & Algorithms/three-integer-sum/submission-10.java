class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int other = nums[i] * -1;

            List<List<Integer>> tempRes = findTwo(nums, other, i + 1);

            if (tempRes.isEmpty()) continue;    

            for (List<Integer> tempList : tempRes) {
                List<Integer> newList = List.of(nums[i], tempList.get(0), tempList.get(1));
                //if (!result.contains(newList))
                    result.add(newList);
            }
        }

        return result;
    }

    private List<List<Integer>> findTwo(int[] nums, int target, int start) {
        int end = nums.length - 1;

        List<List<Integer>> result = new ArrayList<>();

        while(start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                result.add(List.of(nums[start], nums[end]));
                while (start < end && nums[start] == nums[start + 1]) start++;
                while (start < end && nums[end] == nums[end - 1]) end--;
                
            }
            if (sum > target) end--;
            else start++;
        }

        return result;
    }
}
