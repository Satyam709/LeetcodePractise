import java.util.ArrayList;
import java.util.List;

public class CandidatesSum {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int[] marks = new int[51]; // Assuming values in candidates are <= 50
        for (int i : candidates) {
            marks[i]++;
        }
        return search(marks, target, 1);
    }

    private List<List<Integer>> search(int[] marks, int k, int start) {
        List<List<Integer>> out = new ArrayList<>();

        for (int i = start; i < marks.length; i++) {
            int count = marks[i];
            if (count > 0) {
                marks[i]--; // Use the current number

                if (i == k) {
                    List<Integer> element = new ArrayList<>();
                    element.add(i);
                    out.add(element);
                } else if (i < k) {
                    List<List<Integer>> sub = search(marks, k - i, i); // Continue from current index

                    for (List<Integer> subList : sub) {
                        List<Integer> element = new ArrayList<>();
                        element.add(i);
                        element.addAll(subList);
                        out.add(element);
                    }
                }
                marks[i]++; // Restore count after backtracking
            }
        }
        return out;
    }


    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        int k = 8;
        CandidatesSum obj = new CandidatesSum();
        System.out.println(obj.combinationSum2(arr, k));
    }
}
