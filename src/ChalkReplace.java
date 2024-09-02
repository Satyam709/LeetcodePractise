public class ChalkReplace {
    public static int chalkReplacer(int[] chalk, int k) {
        int sum = 0;
        for (int i = 0; i < chalk.length; i++){
            sum += chalk[i];
            if (sum > k) {
                return i;
            }
        }
        k = k % sum;
        sum = 0;
        for (int i = 0; i < chalk.length; i++) {
            sum += chalk[i];
            if (sum > k) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] chalk  = {5,1,5};
        int k =22;

        System.out.println(chalkReplacer(chalk,k));
    }
}
