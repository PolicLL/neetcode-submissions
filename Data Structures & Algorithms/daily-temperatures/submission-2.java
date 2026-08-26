class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int stackIndex = 1;
        Temp[] stack = new Temp[temperatures.length];
        stack[0] = new Temp(temperatures[0], 0);

        int[] result = new int[temperatures.length];

        for (int i = 1; i < temperatures.length; ++i) {
            int temp = temperatures[i];

            int removed = 0;

            for (int j = stackIndex - 1; j >= 0; --j) {
                Temp previous = stack[j];
                if (temp > previous.value()) {
                    result[previous.index()] = i - previous.index();
                    removed++;
                }
            }

            stackIndex -= removed;

            stack[stackIndex++] = new Temp(temp, i);
        }
        

        return result;
    }

    public record Temp(int value, int index) {}
}
