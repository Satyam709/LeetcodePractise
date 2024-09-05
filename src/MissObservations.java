import java.util.Arrays;

public class MissObservations {
    public int[] missingRolls(int[] rolls, int mean, int n) {

        int totalSum = (rolls.length + n) * mean;
        int sum = 0;
        for (int i : rolls) sum += i;
        int rem = totalSum - sum;
        if (rem > 6 * n || rem < n) return new int[]{};
        int[] out = new int[n];
        int bank = -1;

        for (int i = 0; i < n; i++) {

            if (rem >= 6) {
                out[i] = 6;
            } else if (rem > 0) {
                out[i] = rem;
            } else {
                if (out[bank] == 1) bank--;
                out[bank]--;
                out[i]++;
            }
            rem -= out[i];
            if (rem == 0)bank=i;
            // System.out.println(Arrays.toString(out));
        }

        return out;
    }

    public static void main(String[] args) {
        int[] rolls = {6,1,5,2};
        int mean = 4;
        int n = 4;

        MissObservations obj = new MissObservations();

        System.out.println(Arrays.toString(obj.missingRolls(rolls, mean, n)));
    }
}
