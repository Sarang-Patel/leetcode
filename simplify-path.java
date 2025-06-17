# Simplify Path
class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();

        for(String s: path.split("/")) {
            if(s.equals(".") || s.equals("")) continue;
            else if(s.equals("..")) {
                if(!stack.isEmpty()) stack.pollLast();
            }else {
                stack.offerLast(s);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("/");
        
        while(!stack.isEmpty()) {
            sb.append(stack.pollFirst()).append("/");
        }

        if(sb.length() == 1)
        return sb.toString();

        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}