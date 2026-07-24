class StreamChecker {

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        boolean isWord = false;
    }

    private TrieNode root;
    private StringBuilder stream;
    private int maxLen;

    public StreamChecker(String[] words) {
        root = new TrieNode();
        stream = new StringBuilder();
        maxLen = 0;

        for (String word : words) {
            maxLen = Math.max(maxLen, word.length());
            TrieNode node = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                int idx = word.charAt(i) - 'a';
                if (node.next[idx] == null) {
                    node.next[idx] = new TrieNode();
                }
                node = node.next[idx];
            }
            node.isWord = true;
        }
    }

    public boolean query(char letter) {
        stream.append(letter);

        if (stream.length() > maxLen) {
            stream.deleteCharAt(0);
        }

        TrieNode node = root;
        for (int i = stream.length() - 1; i >= 0; i--) {
            int idx = stream.charAt(i) - 'a';
            if (node.next[idx] == null) {
                return false;
            }
            node = node.next[idx];
            if (node.isWord) {
                return true;
            }
        }

        return false;
    }
}