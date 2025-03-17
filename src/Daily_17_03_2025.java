public class Daily_17_03_2025 {
    public boolean divideArray(int[] nums) {
        int[] freq = new int[501];
        for (int i : nums){
            freq[i]++;
        }
        for (int i:freq)if ((i&1)!=0)return false;
        return true;
    }
    public static void main(String[] args) {
    }
}
