class Trie {
    Trie[] children = new Trie[26];
    boolean isEnd = false;

    void insert(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null) {
                node.children[i] = new Trie();
            }
            node = node.children[i];
        }
    }
}

class Solution {
    Trie trie;
    char[] s;
    Integer[] f;
    private final int INF = 99999999;
    public int minValidStrings(String[] words, String target) {
        trie = new Trie();

        for (String word : words) {
            trie.insert(word);
        }
        s = target.toCharArray();
        f = new Integer[s.length];
        int answer = dfs(0);
        if (answer < INF) {
            return answer;
        }
        return -1;
    }

    int dfs(int i) {
        if (i >= s.length) {
            return 0;
        }
        if (f[i] != null) {
            return f[i];
        }
        Trie node = trie;
        f[i] = INF;
        for (int j = i; j < s.length; j++) {
            int k = s[j] - 'a';
            if (node.children[k] == null) {
                break;
            }
            f[i] = Math.min(f[i], dfs(j + 1) + 1);
            node = node.children[k];
        }
        return f[i];
    }
}
