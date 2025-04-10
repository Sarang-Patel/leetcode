# Word Search II
class Solution {

    class Node {
        Node[] children;
        String word;

        Node() {
            this.children = new Node[26];
            this.word = null;
        }
    }

    Node root;

    public void insert(String word) {
        Node temp = root;

        for (char c : word.toCharArray()) {
            if (temp.children[c - 'a'] == null) {
                temp.children[c - 'a'] = new Node();
            }
            temp = temp.children[c - 'a'];
        }

        temp.word = word;
    }

    List<String> result = new ArrayList<>();

    char[][] board;
    int m;
    int n;

    int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    public List<String> findWords(char[][] board, String[] words) {
        this.root = new Node();
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;

        for (String s : words) {
            insert(s);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                backtrack(board, i, j, root);
            }
        }

        return result;
    }

    public boolean check(int row, int col) {
        if (row < 0 || col < 0 || row >= m || col >= n)
            return false;
        return true;
    }

    public boolean isEmpty(Node node) {
        for(Node child : node.children) {
            if(child != null) return false;
        }

        return true;
    }

    public void backtrack(char[][] board, int row, int col, Node temp) {

        if (!check(row, col))
            return;

        char c = board[row][col];

        if (c == '#' || temp.children[c - 'a'] == null)
            return;

        Node next = temp.children[c-'a'];

        if (next.word != null) {
            result.add(next.word);
            next.word = null;
        }

        board[row][col] = '#';

        for(int[] dir: dirs){
            backtrack(board, row + dir[0], col + dir[1], next);
        }

        board[row][col] = c;
        
        if(isEmpty(next) && next.word == null)
        temp.children[c - 'a'] = null;
    }
}