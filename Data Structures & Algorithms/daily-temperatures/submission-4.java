class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> temp = new ArrayDeque<>();
        Deque<Integer> indexes = new ArrayDeque<>();

        temp.push(temperatures[0]);
        indexes.push(0);

        int[] result = new int[temperatures.length];

        for (int i = 1; i < temperatures.length; ++i) {
            int val = temperatures[i];


            while (!temp.isEmpty() && val > temp.peek()) {
                int index = indexes.pop();
                result[index] = i - index;
                temp.pop();
            }

            temp.push(val);
            indexes.push(i);
        }
        

        return result;
    }
}
