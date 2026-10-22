class Solution {

    private Map<Character, Integer> map;
    private String min = "";
    private int left = 0;
    private int right = 0;
    private int size = 0;

    public String minWindow(String s, String t) {
        map = populateMap(t);
        size = s.length();
    
        while (left < size || right < size) {
            if (right >= size) {
                while (isCorrect()) {
                    calculateMin(s);
                }

                return min;
            }

            decrementElement(s.charAt(right));
            
            while (isCorrect()) {
                calculateMin(s);
            }

            ++right;
        }

        return min;
    }

    private void calculateMin(String main) {
        int tempLength = min.length();
        int newLength = (right - left) + 1;

        //if (right == size) newLength--;
        if (tempLength == 0 || tempLength > newLength) min = main.substring(left, right + 1);
        
        int removedSignIndex = left++;
        incrementElement(main.charAt(removedSignIndex));
    }

    private void incrementElement(char key) {
        if (map.containsKey(key)) {
            map.merge(key, 1, Integer::sum);
        }
    }

    private void decrementElement(char key) {
        if (map.containsKey(key)) {
            map.merge(key, -1, Integer::sum);
        }
    }

    private boolean isCorrect() {
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
