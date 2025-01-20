class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> map = new HashMap<>();

        for(String i: strs) {
            char[] arr = i.toCharArray();
            Arrays.sort(arr);

            String key = new String(arr);

            if(map.containsKey(key)) {
                map.get(key).add(i);
            }else{
                map.put(key, new ArrayList<>());
                map.get(key).add(i);

            }


        }

        return new ArrayList<>(map.values());

    }
}