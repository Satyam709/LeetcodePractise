import java.util.Arrays;

public class PrefixScores {
    public int[] sumPrefixScores(String[] words) {

        TrieCount trie = new TrieCount();

        for (String i : words){
            trie.put(i);
        }

        int[] out = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            out[i] = trie.getScore(words[i]);
        }
        return out;
    }

    public static void main(String[] args) {
        PrefixScores obj = new PrefixScores();

        String[] words = {"abc","ab","bc","b"};
        System.out.println("score = "+ Arrays.toString(obj.sumPrefixScores(words)));

    }

}
class TrieCount{

    private Node root;

    TrieCount(){
        root = new Node();
    }

    static class Node{
        int val = 0;
        Node[] next;
        Node()
        {
            next = new Node[26];
        }
    }

    public void put(String s){
        root = put(root,s,0);
    }

    private Node put(Node root,String s, int l){
        if (root == null)
            root = new Node();

        if (l>0)root.val+=1;

        if (l == s.length()){
            return root;
        }

        int ch = s.charAt(l) - 'a';
        root.next[ch] = put(root.next[ch],s,l+1);

        return root;
    }

    public int getScore(String s){
        Node root = this.root;
        if (root == null)return 0;

        int l =0,sum =0;

        while (l<s.length() && root.next[s.charAt(l)-'a']!=null){
            root = root.next[s.charAt(l)-'a'];
            sum += root.val;
            l++;
        }
        return sum;
    }
}
