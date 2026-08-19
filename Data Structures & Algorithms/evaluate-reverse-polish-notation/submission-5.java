class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> num = new ArrayDeque<>();
        Deque<Character> op = new ArrayDeque<>();

        String numbers = "123456789";

        for (int i = 0; i < tokens.length; ++i) {
            try {
                int number = Integer.parseInt(tokens[i]);
                num.push(number);
            } catch (NumberFormatException e) {
                int a = num.pop();
                int b = num.pop();
                num.push(calculate(b, a, tokens[i]));
            }
        }

        return num.pop();
    }

    private int calculate(int a, int b, String o) {
        if (o.equals("+"))
            return a + b;
        if (o.equals("-"))
            return a - b;
        if (o.equals("*"))
            return a * b;
        if (o.equals("/"))
            return a / b;

        return -1;
    }
}
