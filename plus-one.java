# Plus One
class Solution {
    public int[] plusOne(int[] digits) {
        ArrayList<Integer> arr = new ArrayList<>();
        int carry = 0;
        for(int i = digits.length-1; i >= 0; i--) {
            int j = 0;
            if(i == digits.length - 1){
            j = digits[i] + 1 + carry;}
            else{
            j = digits[i] + carry;}
            carry = j/10;
            System.out.println(carry);
            digits[i] = j%10;
            arr.add(0, digits[i]);
        }

        if(carry != 0) {
            arr.add(0, carry);
        }
        int[] array = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            array[i] = arr.get(i);
        }

        return array;
    }
}