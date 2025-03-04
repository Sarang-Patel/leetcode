# Last Stone Weight
class Solution {
     
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for(int i: stones) {
            q.add(i);
        }


        while(true) {
            int x;
            int y;
            if(q.size() > 1) {
                x = q.poll();
                y = q.poll();
            }else{
                break;
            }

            if(x == y) {
                continue;
            }else{
                q.add(x < y ? y - x : x - y);
            } 
        }

        if(q.size() == 1)
        return q.poll();

        return 0;



    }
}