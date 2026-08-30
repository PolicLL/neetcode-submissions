class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Deque<Area> stack = new ArrayDeque<>();

        // 3 6 

        for (int i = 0; i < heights.length; ++i) {
            Area newArea = new Area(i, heights[i]);
            if (!stack.isEmpty() && heights[i] < stack.peek().height) {
                while(!stack.isEmpty() && heights[i] < stack.peek().height) {
                    Area pop = stack.pop();
                    maxArea = Math.max(maxArea, (i - pop.index) * pop.height);
                    newArea = new Area(pop.index, heights[i]);
                }
                stack.push(newArea);
            }
            else
                stack.push(newArea);
        }

        for (Area value : stack) {
            //System.out.println(value);
        }

        //System.out.println("Max: " + maxArea);

        while(!stack.isEmpty()) {
            Area pop = stack.pop();
            maxArea = Math.max(maxArea, (heights.length - pop.index) * pop.height);
        }

        return maxArea;
    }

    public class Area {
        int index; 
        int height;

        Area(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

}

