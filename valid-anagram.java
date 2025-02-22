# Valid Anagram
class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        char[] sarr = s.toCharArray();
        for(char i: sarr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }


        char[] tarr = t.toCharArray();
        for(char i: tarr) {
            map.put(i, map.getOrDefault(i, 0) - 1);

            if(map.get(i) < 0) 
            return false;
        }

        for(int count: map.values()) {
            if(count != 0)
            return false;
        }

        return true;
    }
}