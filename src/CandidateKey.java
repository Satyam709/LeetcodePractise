import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.util.*;

/**
 * CandidateKeys
 */
public class CandidateKey {

    public static Set<Character> findCandidateKey(HashMap<Character, List<Character>> map, Set<Character> relations) {
        System.out.println(relations);
        System.out.println(map);
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(relations.size());

        HashMap<Character,Integer> idx = new HashMap<>(relations.size());

        int j = 0;
        for (Character i : relations){
            idx.put(i,j++);
        }
        System.out.println(idx);

        for (Character i : relations){

        }


        return null;
    }
    private int put(Character x){
        return x - 'A';
    }

    public static void main(String[] args) {
        HashMap<Character, List<Character>> map = new HashMap<>();
        map.put('A', new ArrayList<>(Arrays.asList('B')));
        map.put('C', new ArrayList<>(Arrays.asList('D')));
        map.put('E', new ArrayList<>());

        HashSet<Character> set = new HashSet<>();
        set.add('A');
        set.add('B');
        set.add('C');
        set.add('D');
        set.add('E');

        System.out.println(findCandidateKey(map, set));
    }
}