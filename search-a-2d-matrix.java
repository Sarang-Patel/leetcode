# Search a 2D Matrix
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m*n - 1;

        while(left <= right) {
            int mid = left  + (right - left) / 2;

            int value = matrix[mid / n][mid % n];

            if(value == target) {
                return true;
            }else if(value < target) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return false;

    }
}