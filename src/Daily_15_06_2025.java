public class Daily_15_06_2025 {
    public static int maxDiff(int num) {
        boolean allSame = true;
        char[] nums = ("" + num).toCharArray();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                allSame = false;
                break;
            }
        }

        if (allSame) {
            return Integer.parseInt("8".repeat(nums.length));
        }

        // get min
        int minNum = 0;
        int target = -1;
        int to = nums[0] == '1' ? 0 : 1;
        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] == '1' || nums[i] == '0') {
                minNum = minNum * 10 + nums[i] - '0';
                continue;
            }
            target = nums[i];
            break;
        }
        for (; i < nums.length; i++) {
            if (nums[i] == target) minNum = minNum * 10 + to;
            else minNum = minNum * 10 + nums[i] - '0';
        }

        // get max
        int maxNum = 0;
        target = -1;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] == '9') {
                maxNum = maxNum * 10 + nums[i] - '0';
                continue;
            }
            target = nums[i];
            break;
        }
        for (; i < nums.length; i++) {
            if (nums[i] == target) maxNum = maxNum * 10 + 9;
            else maxNum = maxNum * 10 + nums[i] - '0';

        }
        return maxNum - minNum;
    }

    public static void main(String[] args) {
        int num1 = 928;
        int num2 = 9;
        System.out.println(maxDiff(num1));
        System.out.println(maxDiff(num2));
    }
}
