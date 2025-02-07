# Missing Number
class Solution {
    public int missingNumber(int[] nums) {

        int n = nums.length;
        int sr = (n * (n+1))/2;
        int sa = 0;
        for(int i: nums){
            sa+=i;
        }

        return sr-sa;    
    
    }

}