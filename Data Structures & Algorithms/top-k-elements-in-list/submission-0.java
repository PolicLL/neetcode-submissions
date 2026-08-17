class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int x : nums) {
            map.merge(x, 1, Integer::sum);
        }

        int[] result = new int[k];

        for(int i = 0; i < k; ++i) {
            int x = mostFrequent(map);
            result[i] = x;
            map.put(x, 0);
        }

        return result;
    }

    private int mostFrequent(Map<Integer, Integer> map) {
        int number = -1, times = -1;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() >  times) {
                number = entry.getKey();
                times = entry.getValue();
            }
        }

        return number;
    }
}
