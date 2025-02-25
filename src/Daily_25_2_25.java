public class Daily_25_2_25 {
    public static int numOfSubarrays(int[] arr) {
        int sum = arr[0];
        int po = 0;
        int fac = (int) 1e9 + 7;
        long count = 0;

        for (int i = 1; i < arr.length; i++) {
            po += sum % 2;
            sum += arr[i];
            count += sum % 2 == 0 ? po : i + 1 - po;
        }
        return (int) ((count + (arr[0] % 2 == 0 ? 0 : 1)) % fac);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5};
        System.out.println(numOfSubarrays(arr));
    }
}
