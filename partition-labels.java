# Partition Labels
class Solution {
    public List<Integer> partitionLabels(String s) {
    int[] last = new int[26];
    for (int i = 0; i < s.length(); i++) {
        last[s.charAt(i) - 'a'] = i;
    }

    List<Integer> res = new ArrayList<>();
    int maxPartition = 0, start = 0;

    for (int i = 0; i < s.length(); i++) {
        maxPartition = Math.max(maxPartition, last[s.charAt(i) - 'a']);
        if (i == maxPartition) {
            res.add(i - start + 1);
            start = i + 1;
        }
    }

    return res;
}

}