# Top K Frequent Elements
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i: nums) {
            map.put(i, map.getOrDefault(i,0) + 1);
        }

        List<Integer>[] freq = new List[nums.length + 1];

        for(int i: map.keySet()) {
            int f = map.get(i);

            if(freq[f] == null) {
                freq[f] = new ArrayList<>();
            }

            freq[f].add(i);
        }

        int[] res = new int[k];
        k -= 1;
        for(int i = freq.length - 1; i >= 0; i--) {
            if(freq[i] != null) {
                for(int j = 0; j < freq[i].size() && k >=0 ; j++) {
                    res[k] = freq[i].get(j);
                    k-=1;
                }
            }
        }

        return res;

    }
}