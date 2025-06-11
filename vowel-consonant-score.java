# Vowel-Consonant Score
class Solution {
    public int vowelConsonantScore(String s) {
        int c = 0;
        int v = 0;

        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
        
        for(char ch: s.toCharArray()) {
            if(set.contains(ch)) {
                v++;
            }else {
                if(Character.isLetter(ch)) {
                    c++;
                }
            }
        }

        if(c > 0) return (int) Math.floor(v/c);
        return 0;
    }
}