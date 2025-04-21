# Multiply Strings
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.length() < num2.length())
            return multiply(num2, num1);
        int[] res = new int[num1.length() + num2.length()];

        for (int i = num2.length() - 1; i >= 0; i--) {
            for (int j = num1.length() - 1; j >= 0; j--) {
                int mul = Character.getNumericValue(num2.charAt(i)) * Character.getNumericValue(num1.charAt(j));
                int position1 = i + j;
                int position2 = i + j + 1;

                res[position2] += mul;
                res[position1] += res[position2] / 10;
                res[position2] %= 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : res) {
            if (!(sb.length() == 0 && num == 0))
                sb.append(num);
        }
        return sb.length() == 0 ? "0" : sb.toString();

    }
}