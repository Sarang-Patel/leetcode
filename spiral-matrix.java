# Spiral Matrix
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int leftBorder = 0;
        int topBorder = 0;
        int rightBorder = matrix[0].length - 1;
        int bottomBorder = matrix.length - 1;

        int total = matrix.length * matrix[0].length;

        while(topBorder <= bottomBorder && leftBorder <= rightBorder) {

            for(int col = leftBorder; col <= rightBorder; col++) {
                res.add(matrix[topBorder][col]);
            }

            for(int row = topBorder + 1; row <= bottomBorder; row++) {
                res.add(matrix[row][rightBorder]);
            }

            if(topBorder < bottomBorder){
            for(int col = rightBorder - 1; col >= leftBorder; col--) {
                res.add(matrix[bottomBorder][col]);
            }}

            if(leftBorder < rightBorder){
            for(int row = bottomBorder - 1; row > topBorder; row--) {
                res.add(matrix[row][leftBorder]);
            }}

            topBorder++;
            leftBorder++;
            rightBorder--;
            bottomBorder--;

        }

        return res;

    }
}