class MinStack {

    private int[] stack;
    private int index = 0;
    private int min = Integer.MAX_VALUE;

    public MinStack() {
        stack = new int[10];
    }
    
    public void push(int val) {
        if(index == stack.length) {
            int newArr[] = new int[stack.length * 2];
            for (int i = 0; i < stack.length; ++i)
                newArr[i] = stack[i];

            stack = newArr;
        }

        if (val < min)
            min = val;

        stack[index++] = val;
    }
    
    public void pop() {
        if(index > -1) {
            index--;
            if (stack[index] == min) {
                int newMin = Integer.MAX_VALUE;
                for (int i = 0; i < index; ++i) {
                    if (newMin > stack[i])
                        newMin = stack[i];
                }
                min = newMin;
            }
        }
    }
    
    public int top() {
        return index > 0 ? stack[index - 1] : -1;
    }
    
    public int getMin() {
        return min;
    }
}
