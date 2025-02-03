# Min Stack
class MinStack {
    ArrayList<int[]> stack;
    int min;

    public MinStack() {
        stack = new ArrayList<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        min = Math.min(val, min);
        stack.add(new int[] { val, min });
    }

    public void pop() {
        if (!stack.isEmpty()) {
        stack.remove(stack.size() - 1);
        if (!stack.isEmpty()) {
            min = getMin();
        } else {
            min = Integer.MAX_VALUE;  
        }
    }

    }

    public int top() {
        return stack.get(stack.size() - 1)[0];
    }

    public int getMin() {
        return stack.get(stack.size() - 1)[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */