# Merge Triplets to Form Target Triplet
class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean a = false;
        boolean b = false;
        boolean c = false;
        for(int i = 0 ; i < triplets.length; i++){
            if(triplets[i][0] > target[0] || triplets[i][1] > target[1] || triplets[i][2] > target[2]){
                continue;
            }
            if(triplets[i][0] == target[0]){
                a = true;
            }
            if(triplets[i][1] == target[1]){
                b = true;
            }
            if(triplets[i][2] == target[2]){
                c = true;
            }
            if(a && b && c){
                return true;
            }
        }
        return false;
        
        
    }
}