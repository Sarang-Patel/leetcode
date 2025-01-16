# Evaluate Reverse Polish Notation
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();

        for (String i : tokens) {
            if (i.equals("+") || i.equals("-") || i.equals("*") || i.equals("/")) {
                int first = Integer.parseInt(stack.pop());
                int second = Integer.parseInt(stack.pop());

                switch (i) {
                    case ("+"):
                        stack.push(String.valueOf(first + second));
                        break;
                    case ("-"):
                        stack.push(String.valueOf(second - first));
                        break;
                    case ("*"):
                        stack.push(String.valueOf(first * second));
                        break;
                    case ("/"):
                        stack.push(String.valueOf(second / first));
                        break;
                }
            } else {
                stack.push(i);
            }
        }

        return Integer.parseInt(stack.pop());
    }
}