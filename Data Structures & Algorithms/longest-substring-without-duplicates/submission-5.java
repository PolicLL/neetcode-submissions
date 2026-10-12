class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;

        Set<Character> set = new HashSet<>();
        Deque<Character> queue = new LinkedList<>();

        for (int i = 0; i < s.length(); ++i) {
            char temp = s.charAt(i);
            //queue.add(temp);
            if (!set.contains(temp)) {
                set.add(temp);
                queue.add(temp);
                longest = Math.max(longest, queue.size());
            } else {
                while (true) {
                    char removedElement = queue.poll();
                    set.remove(removedElement);
                    if (removedElement == temp) break;
                }
                set.add(temp);
                queue.add(temp);
            }
        }

        return longest;
    }
}
