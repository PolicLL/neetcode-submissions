class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); ++i) {
            Character x = Character.valueOf(s.charAt(i));
            map.merge(x, 1, Integer::sum);
        }

        for (int i = 0; i < t.length(); ++i) {
            Character x = Character.valueOf(t.charAt(i));
            map.merge(x, -1, Integer::sum);
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) return false;
        }

        return true;
    }
}
