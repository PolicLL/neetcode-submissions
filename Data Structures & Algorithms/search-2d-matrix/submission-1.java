class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0, end = matrix.length - 1;
        int row = 0;
        while(start <= end) {
            int mid = (start + end) / 2;
            int midVal = matrix[mid][0];
            row = mid;
            if (midVal == target) return true;
            if (target > midVal && (mid + 1) < matrix.length && 
                matrix[mid + 1][0] > target) {
                    break;
                }
            else if(target < midVal) {
                end = mid - 1;
            }
            else start = mid + 1;
        }

        return binary(matrix[row], target) != -1 ? true : false;


    }

    private int binary(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] > target) end = mid - 1;
            else start = mid + 1;
        }

        return -1;
    }
}
