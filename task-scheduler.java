# Task Scheduler
class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;

        for(char c: tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            
            max = Math.max(max, map.get(c));
        }
        int cnt = 0;
        for(int i : map.values()) {
            if(i == max)
            cnt++;
        }

        return Math.max(tasks.length, (max - 1) * (n + 1) + cnt);
    }
}