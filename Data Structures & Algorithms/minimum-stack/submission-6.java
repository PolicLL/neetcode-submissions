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

        //System.out.println("push");
        //print();
    }
    
    public void pop() {
        //System.out.println("pop");
//print();
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

       // print();
    }
    
    public int top() {
        //System.out.println("top");
        //print();

        return index > 0 ? stack[index - 1] : -1;
    }
    
    public int getMin() {
        //System.out.println("getMin");
       // print();

        return min;
    }


    private void print() {
        for (int i = 0; i < stack.length; ++i)
            System.out.print(stack[i] + " ");
        System.out.println("index: " + index);
    }
}
