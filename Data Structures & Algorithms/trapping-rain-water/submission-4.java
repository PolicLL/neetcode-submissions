class Solution {
    public int trap(int[] height) {
        int start = -1, area = 0;

        for (int i = 0; i < height.length; ++i) {
            int temp = height[i];
            if (temp > 0) {
                if (start == -1) {
                    start = i;
                    int future = futureMax(height, i);
                    if (future < height[start]) {
                        height[start] = future;
                    }
                }
                else if (start != -1 && temp >= height[start]) {
                    area += calculateArea(height, start, i);

                    start = i;
                    int future = futureMax(height, i);
                    if (future < height[start]) {
                        height[start] = future;
                    }
                } 
            }
        }

        return area;
    }

    private int calculateArea(int[] height, int i, int j) {
        if (i == -1) return 0;
        //System.out.println("i: " + i + "j: " + j);

        int min = Math.min(height[i], height[j]);

        int area = 0;
        int start = i + 1;
        int end = j - 1;

        while (start <= end) {
            area += min - height[start++];
        }

        return area;
    }

    private int futureMax(int height[], int index) {
        if (index + 1 >= height.length) return 0;
        int max = height[index + 1];
        for (int i = index + 2; i < height.length; ++i) {
            if (height[i] >= max) max = height[i];
        }

        return max;
    }
}
