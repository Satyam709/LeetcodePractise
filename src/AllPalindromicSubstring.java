import java.util.ArrayList;
import java.util.List;

public class AllPalindromicSubstring {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        getCombinations(0,s,new ArrayList<>(),res);
        return res;
    }
    private void getCombinations(int from,String s,List<String> path,List<List<String>> res){
        if(from == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=from;i<s.length();i++){
            if(isPalindrome(s,from,i)){
                path.add(s.substring(from,i+1));
                getCombinations(i+1,s,path,res);
                path.removeLast();
            }
        }
    }
    private boolean isPalindrome(String s,int from,int to){
        while(from<=to){
            if(s.charAt(from++)!=s.charAt(to--)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        AllPalindromicSubstring sol = new AllPalindromicSubstring();
        System.out.println(sol.partition("abcd"));
        System.out.println(sol.partition("a"));
        System.out.println(sol.partition("aab"));
        System.out.println(sol.partition("aab"));
    }
}
