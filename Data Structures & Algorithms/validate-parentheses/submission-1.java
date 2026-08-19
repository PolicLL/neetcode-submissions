class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0) return true;
        if(s.length() % 2 != 0) return false;

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); ++i) {
            char tmp = s.charAt(i);
            if (isClosing(tmp)) {
                if (stack.isEmpty()) return false;
                if (doesMatch(stack.peek(), tmp)) {
                    stack.pop();
                }
                else return false;
            }
            else {
                stack.push(tmp);
            }
        }

        if (stack.isEmpty()) return true;

        return false;
    }

    private boolean doesMatch(char a, char b) {
        return ((a == '[') && (b == ']')) || 
                ((a == '(') && (b == ')')) ||
                ((a == '{') && (b == '}'));
    }

    private boolean isClosing(char s) {
        return s == ']' || s == ')' || s == '}';
    }

    private boolean isOpening(char s) {
        return s == '{' || s == '(' || s == '[';
    }
}
