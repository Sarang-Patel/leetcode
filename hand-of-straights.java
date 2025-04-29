# Hand of Straights
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;

        Map<Integer, Integer> counts = new HashMap<>();

        for(int card : hand) {
            counts.put(card, counts.getOrDefault(card, 0) + 1);
        }

        Arrays.sort(hand);


        for(int card : hand) {
            int c = counts.get(card);
            if(c == 0) continue;

            for(int start = card; start < card + groupSize; start++) {
                int freq = counts.getOrDefault(start, 0);
                if(freq < c) return false;

                counts.put(start, freq - c);
            }
        }

        return true;


    }
}