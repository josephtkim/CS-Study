import java.util.HashMap;
import java.util.Map;

/*
Prefix tree, or Trie
Based on implementation by awangdev
 */
public class Trie {

    private static final int ALPHABET_SIZE = 26;

    private class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEnd;

        public TrieNode() {
            children = new HashMap<>();
            isEnd = false;
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public boolean find(String word) {
        if (word == null || word.length() < 1) {
            return false;
        }

        TrieNode current = root;

        // Iterate over each child of the current string
        for (char c : word.toCharArray()) {
            if (current.children.containsKey(c)) {
                current = current.children.get(c);
            } else {
                return false;
            }
        }

        return current.isEnd;
    }

    public void insert(String word) {
        if (word == null || word.length() < 1 || find(word)) {
            return;
        }

        TrieNode current = root;

        for (char c : word.toCharArray()) {
            if (current.children.containsKey(c)) { // Character is already in trie, so continue
                current = current.children.get(c);
            } else {
                current.children.put(c, new TrieNode());
                current = current.children.get(c);
            }
        }

        current.isEnd = true;
    }

    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() < 1) {
            return false;
        }

        TrieNode current = root;

        for (char c : prefix.toCharArray()) {
            if (current.children.containsKey(c)) {
                current = current.children.get(c);
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Trie t = new Trie();

        t.insert("banana");
        t.insert("bandana");

        System.out.println(t.startsWith("ban"));
        System.out.println(t.startsWith("bad"));
        System.out.println(t.find("banana"));
        System.out.println(t.find("bandana"));
    }
}
