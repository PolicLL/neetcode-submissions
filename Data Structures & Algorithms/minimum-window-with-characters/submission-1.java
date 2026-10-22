class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = populateMap(t);
        String min = "";

        int left = 0, right = 0, size = s.length();
        
        // OUZOD YXAZV

        while (left < size || right < size) {
            //System.out.println("left right " + left + " " + right);
            if (right >= size) {
                while (isCorrect(map)) {
                    int tempLength = min.length();
                    int newLength = right + 1;
                    if (tempLength == 0 || tempLength > newLength) min = s.substring(left, newLength);
                    
                    int removedSignIndex = left++;
                    incrementElement(map, s.charAt(removedSignIndex));
                }

                return min;
            }

            decrementElement(map, s.charAt(right));
            
            while (isCorrect(map)) {
                int tempLength = min.length();
                int newLength = (right - left) + 1;
                if (right == size) newLength--;
                if (tempLength == 0 || tempLength > newLength) {
                     //System.out.println("left newLength " + left + " " + newLength);
                     min = s.substring(left, right + 1);
                }
                
                int removedSignIndex = left++;
                incrementElement(map, s.charAt(removedSignIndex));
            }

            ++right;
        }

        return min;
    }

    private void incrementElement(Map<Character, Integer> map, char key) {
        if (map.containsKey(key)) {
            map.merge(key, 1, Integer::sum);
        }
    }

    private void decrementElement(Map<Character, Integer> map, char key) {
        if (map.containsKey(key)) {
            map.merge(key, -1, Integer::sum);
        }
    }

    private int sumMap(Map<Character, Integer> map) {
        return map.values().stream().mapToInt(Integer::intValue).sum();
    }

    private boolean isCorrect(Map<Character, Integer> map) {
        return map.values().stream().allMatch(value -> value <= 0);
    }

    private Map<Character, Integer> populateMap(String input) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < input.length(); ++i) {
            map.merge(input.charAt(i), 1, Integer::sum);
        }

        return map;
    }
}
