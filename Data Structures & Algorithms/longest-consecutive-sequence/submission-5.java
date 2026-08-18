class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        /*

        */

        for (int a : nums) {
            map.put(a, 0);
        }

        for (int a : nums) {
            if (map.containsKey(a - 1) == true) {
                map.put(a, 1);
            }
        }

        int max = 0;
        List<Integer> starts = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) {
                int element = entry.getKey();
                int tempElement = element + 1;
                int distance = 1;

                while (map.containsKey(tempElement)) {
                    tempElement++;
                    distance++;
                }

                if (distance > max)
                    max = distance;
            }
        }

        return max;
    }
}
