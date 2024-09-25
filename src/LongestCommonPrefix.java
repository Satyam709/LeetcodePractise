public class LongestCommonPrefix {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie<Integer> trie = new Trie<>(10, '0');

        for (int j : arr2) {
            trie.put("" + j, -1);
        }

        int l = 0;
        for (int j : arr1) {
            String s = String.valueOf(j);
            l = Math.max(l, trie.getCommonLongestPrefixLength(s));
        }
        return l;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 10, 100};
        int[] arr2 = {1000};

        LongestCommonPrefix obj = new LongestCommonPrefix();
        System.out.println(obj.longestCommonPrefix(arr1, arr2));
    }
}

class Trie<T> {
    private final int R;
    private final int fix;
    private final Node root;

    Trie(int R) {
        this(R, 0);
    }

    Trie(int R, int fix) {
        this.R = R;
        this.fix = fix;
        this.root = new Node(R);
    }

    Trie() {
        this.R = 256;
        this.fix = 0;
        this.root = new Node(256);
    }

    private static class Node {
        Object val;
        Node[] next;

        Node(int R) {
            next = new Node[R];
        }
    }

    public void put(String s, T val) {
        put(root, 0, s, val);
    }

    private Node put(Node node, int l, String s, T val) {
        if (node == null) {
            node = new Node(R);
        }

        if (l == s.length()) {
            node.val = val;
            return node;
        }

        char ch = s.charAt(l);
        node.next[ch - fix] = put(node.next[ch - fix], l + 1, s, val);

        return node;
    }

    public int getCommonLongestPrefixLength(String s) {
        Node node = root;
        int l = 0;

        while (l < s.length() && node.next[s.charAt(l) - fix] != null) {
            node = node.next[s.charAt(l) - fix];
            l++;
        }

        return l;
    }
}
