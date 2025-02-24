# Valid Parentheses
class Solution {
    public boolean isValid(String s) {
        if (s.length() == 1) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();

        char[] arr = s.toCharArray();

        for (char i : arr) {
            if (i == '(' || i == '[' || i == '{') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    char check = stack.pop();

                    switch (i) {
                        case ')':
                            if (check == '(') {
                                continue;
                            } else {
                                return false;
                            }
                        case '}':
                            if (check == '{') {
                                continue;
                            } else {
                                return false;
                            }
                        case ']':
                            if (check == '[') {
                                continue;
                            } else {
                                return false;
                            }
                    }
                }else{return false;}

            }
        }

        if(!stack.isEmpty())
        return false;

        return true;
    }
}