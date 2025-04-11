# Design Add and Search Words Data Structure
class WordDictionary {

    class Node {
        Node[] children;
        boolean isEndOfWord;

        Node() {
            this.children = new Node[26];
            isEndOfWord = false;
        }
    }

    Node root;

    public WordDictionary() {
        this.root = new Node();

    }

    public void addWord(String word) {
        Node temp = root;

        for (char c : word.toCharArray()) {
            if (temp.children[c - 'a'] == null) {
                temp.children[c - 'a'] = new Node();
            }
            temp = temp.children[c - 'a'];
        }

        temp.isEndOfWord = true;
    }

    public boolean backtrack(int index, Node temp, String word) {
        if(index == word.length()) {
            return temp.isEndOfWord;
        }

        char c = word.charAt(index);

        if(c == '.') {
            for(Node node : temp.children) {
                if(node != null)
                if (backtrack(index + 1, node, word)) return true;
            }
        }else{
            if(temp.children[c-'a'] == null)
            return false;

            if (backtrack(index + 1, temp.children[c-'a'], word)) return true;
        }

        return false;
    }

    public boolean search(String word) {
        return backtrack(0, root, word);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */