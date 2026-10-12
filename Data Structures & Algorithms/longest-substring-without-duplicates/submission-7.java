class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;

        Deque<Character> queue = new LinkedList<>();

        for (int i = 0; i < s.length(); ++i) {
            char temp = s.charAt(i);

            if (!queue.contains(temp)) {
                queue.add(temp);
                longest = Math.max(longest, queue.size());
            } else {
                while (true) 
                    if (queue.poll() == temp) break;
                queue.add(temp);
            }
        }

        return longest;
    }
}