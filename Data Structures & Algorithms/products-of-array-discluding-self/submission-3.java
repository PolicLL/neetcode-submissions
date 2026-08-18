class Solution {
    public int[] productExceptSelf(int[] nums) {
        // 1  1  2  8
        // 48 24 6  1

        if (nums.length == 0) return new int[] {};
        if (nums.length == 1) return new int[] { nums[0] };
        if (nums.length == 2) return new int[] { nums[1], nums[0] };

        int[] LR = new int[nums.length];
        LR[0] = 1;
        LR[1] = nums[0]; 
        LR[2] = nums[0] * nums[1]; 

        int[] RL = new int[nums.length];
        RL[RL.length - 1] = 1;
        RL[RL.length - 2] = nums[RL.length - 1];
        RL[RL.length - 3] = nums[RL.length - 1] * nums[RL.length - 2];

        for (int i = 3; i < LR.length; ++i) {
            LR[i] = LR[i - 1] * nums[i - 1];
        }

        //printArray(LR);

        for (int i = RL.length - 4; i >= 0; --i) {
            RL[i] = RL[i + 1] * nums[i + 1];
        }

        //printArray(RL);

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; ++i)
            result[i] = LR[i] * RL[i];

        return result;
    }

    private void printArray(int[] arr) {
        System.out.println();

        for (int a : arr)
            System.out.print(a + " ");

        System.out.println();
    }
}  
