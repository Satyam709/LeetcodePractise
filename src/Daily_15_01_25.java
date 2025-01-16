public class Daily_15_01_25 {

    public int xorAllNums(int[] nums1, int[] nums2) {

        if (nums2.length%2 == 0 && nums1.length%2 == 0 )return 0;
        int xor2 = 0;
        for (int i: nums2)xor2^=i;
        if (nums2.length%2 == 0)return xor2;
        int xor1 =0 ;
        for (int i: nums2)xor1^=i;
        return xor1;
    }
}
