class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();

        for(int x : nums) {
            if (map.containsKey(x))
                return true;
            map.put(x, true);
        }

        return false;
    }
}