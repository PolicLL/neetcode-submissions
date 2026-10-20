class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = populateMap(s1);

        int left = 0, right = 0, size = s2.length();

        while (left < size && right < size) {
            //System.out.println(map + " right left " + right + " " + left);
    
            if (isEmpty(map)) return true;

            char temp = s2.charAt(right);
            if (!map.containsKey(temp)) {
                map = populateMap(s1);
                left = right + 1;
            }
            else {
                int val = map.merge(temp, -1, Integer::sum);

                if (val == -1) {
                    map.merge(s2.charAt(left++), 1, Integer::sum);
                }
            }

            if (right < size)
                ++right;

            if (isEmpty(map)) return true;
        }

        return false;

    }

    private Map<Character, Integer> populateMap(String s1) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s1.length(); ++i) {
            map.merge(s1.charAt(i), 1, Integer::sum);
        }

        return map;
    }

    private boolean isEmpty(Map<Character, Integer> map) {
        return map.values().stream().allMatch(value -> value == 0);
    }
}
