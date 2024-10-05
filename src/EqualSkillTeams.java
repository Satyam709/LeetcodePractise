import edu.princeton.cs.algs4.In;

import java.util.Arrays;
import java.util.HashMap;

public class EqualSkillTeams {
    public static long dividePlayers(int[] skill) {
        Arrays.sort(skill);

        long chemistry = 0;
        int sum = skill[0] + skill[skill.length - 1], a, b;

        for (int i = 0; i < skill.length/2; i++) {
            a = skill[i];
            b = skill[skill.length - i - 1];
            if (a + b != sum) return -1;

            chemistry += (long) a * b;

        }

        return chemistry;
    }

    public static void main(String[] args) {

    }
}
