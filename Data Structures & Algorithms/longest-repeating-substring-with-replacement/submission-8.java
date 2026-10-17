class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();

        int left = 0, right = 0, resultMax = 0;

        map.merge(s.charAt(0), 1, Integer::sum);

        while(left != s.length()) {
            int length = right - left + 1;
            int maxFreq = max(map);
            
            if ((length - maxFreq) <= k) {
                resultMax = Math.max(resultMax, length);

                if (right < s.length() - 1) {
                    right++;
                    map.merge(s.charAt(right), 1, Integer::sum);
                }
                else {
                    map.merge(s.charAt(left), -1, Integer::sum);
                    left++;
                }
    
              //  System.out.println("left right length resultMax " + 
                //    left + " " + right + " " + length + " " + resultMax);
            }
            else {
                map.merge(s.charAt(left), -1, Integer::sum);
                left++;
            }
        }

        return resultMax;
    }

    private int max(Map<Character, Integer> map) {
        int max = -1;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) 
                max = entry.getValue();
        }
        
        return max;
    }
}
